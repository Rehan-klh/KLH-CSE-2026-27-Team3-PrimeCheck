package com.primetest.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConfidenceAnalyzer {

    private final MillerRabin millerRabin = new MillerRabin();

    public Map<Integer, Double> confidenceByIterations(int... iterationCounts) {
        Map<Integer, Double> results = new LinkedHashMap<>();

        for (int iterations : iterationCounts) {
            results.put(iterations, millerRabin.confidencePercentage(iterations));
        }

        return results;
    }
}
