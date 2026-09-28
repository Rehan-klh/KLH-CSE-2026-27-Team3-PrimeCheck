package com.primetest.algorithm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Benchmark {

    public record BenchmarkRow(
            int bitLength,
            long millerRabinTimeNanos,
            String result
    ) {}

    private final MillerRabin millerRabin = new MillerRabin();

    public List<BenchmarkRow> benchmark(List<BigInteger> numbers, int iterations) {
        List<BenchmarkRow> rows = new ArrayList<>();

        for (BigInteger number : numbers) {
            long start = System.nanoTime();
            boolean result = millerRabin.isProbablyPrime(number, iterations);
            long elapsed = System.nanoTime() - start;

            rows.add(new BenchmarkRow(
                    number.bitLength(),
                    elapsed,
                    result ? "PROBABLY PRIME" : "COMPOSITE"
            ));
        }

        return rows;
    }
}
