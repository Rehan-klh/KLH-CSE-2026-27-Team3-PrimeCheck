package com.primetest.model;

public record PrimeAnalysisResult(
        String traditionalResult,
        long traditionalTimeNanos,
        String millerRabinResult,
        int iterations,
        long millerRabinTimeNanos,
        double errorProbabilityUpperBound,
        double confidencePercentage
) {
}
