package com.primetest.web;

import com.primetest.algorithm.MillerRabin;
import com.primetest.model.PrimeAnalysisResult;
import com.primetest.algorithm.PrimeAnalyzer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.Map;

@RestController
public class PrimeController {

    private final PrimeAnalyzer analyzer = new PrimeAnalyzer();
    private final MillerRabin millerRabin = new MillerRabin();

    @GetMapping("/api/prime/check")
    public Map<String, Object> check(
            @RequestParam String number,
            @RequestParam(defaultValue = "10") int iterations) {

        if (!number.matches("[0-9]+")) {
            throw new IllegalArgumentException("Number must contain only digits.");
        }

        BigInteger n = new BigInteger(number);
        PrimeAnalysisResult result = analyzer.analyze(n, iterations);

        return Map.of(
                "number", number,
                "bitLength", n.bitLength(),
                "traditionalResult", result.traditionalResult(),
                "traditionalTimeMs", result.traditionalTimeNanos() / 1_000_000.0,
                "millerRabinResult", result.millerRabinResult(),
                "iterations", result.iterations(),
                "millerRabinTimeMs", result.millerRabinTimeNanos() / 1_000_000.0,
                "errorProbabilityUpperBound", result.errorProbabilityUpperBound(),
                "confidencePercentage", result.confidencePercentage()
        );
    }

    @GetMapping("/api/prime/quick-check")
    public Map<String, Object> quickCheck(
            @RequestParam String number,
            @RequestParam(defaultValue = "10") int iterations) {

        if (!number.matches("[0-9]+")) {
            throw new IllegalArgumentException("Number must contain only digits.");
        }

        BigInteger n = new BigInteger(number);
        long start = System.nanoTime();
        boolean probablePrime = millerRabin.isProbablyPrime(n, iterations);
        long elapsed = System.nanoTime() - start;

        return Map.of(
                "result", probablePrime ? "PROBABLY PRIME" : "COMPOSITE",
                "bitLength", n.bitLength(),
                "iterations", iterations,
                "timeMs", elapsed / 1_000_000.0,
                "confidencePercentage", millerRabin.confidencePercentage(iterations)
        );
    }
}
