package com.primetest.algorithm;

import com.primetest.model.PrimeAnalysisResult;

import java.math.BigInteger;

public class PrimeAnalyzer {

    private final NaivePrimeCheck naivePrimeCheck;
    private final MillerRabin millerRabin;

    // Trial division is practical only for relatively small numbers.
    private static final int NAIVE_CHECK_MAX_BITS = 32;

    public PrimeAnalyzer() {
        this.naivePrimeCheck = new NaivePrimeCheck();
        this.millerRabin = new MillerRabin();
    }

    public PrimeAnalysisResult analyze(BigInteger n, int iterations) {

        long millerRabinStart = System.nanoTime();
        boolean probablePrime = millerRabin.isProbablyPrime(n, iterations);
        long millerRabinTime = System.nanoTime() - millerRabinStart;

        String mrResult = probablePrime
                ? "PROBABLY PRIME"
                : "COMPOSITE";

        double error =
                millerRabin.errorProbabilityUpperBound(iterations);

        double confidence =
                millerRabin.confidencePercentage(iterations);

        // For small numbers, also run the deterministic method
        // so we can compare both approaches.
        if (n.bitLength() <= NAIVE_CHECK_MAX_BITS) {

            long traditionalStart = System.nanoTime();
            boolean traditional = naivePrimeCheck.isPrime(n);
            long traditionalTime = System.nanoTime() - traditionalStart;

            String traditionalResult =
                    traditional ? "PRIME" : "COMPOSITE";

            return new PrimeAnalysisResult(
                    traditionalResult,
                    traditionalTime,
                    mrResult,
                    iterations,
                    millerRabinTime,
                    error,
                    confidence
            );
        }

        // For large numbers, skip trial division because it can be
        // impractically slow.
        return new PrimeAnalysisResult(
                "SKIPPED (large input)",
                0,
                mrResult,
                iterations,
                millerRabinTime,
                error,
                confidence
        );
    }
}