package com.primetest.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Educational reservoir sampling implementation.
 */
public class ReservoirSampler<T> {

    private final Random random = new Random();

    public List<T> sample(Iterable<T> stream, int sampleSize) {
        if (sampleSize <= 0) {
            throw new IllegalArgumentException("Sample size must be positive.");
        }

        List<T> reservoir = new ArrayList<>(sampleSize);
        int count = 0;

        for (T item : stream) {
            count++;

            if (reservoir.size() < sampleSize) {
                reservoir.add(item);
            } else {
                int index = random.nextInt(count);
                if (index < sampleSize) {
                    reservoir.set(index, item);
                }
            }
        }

        return reservoir;
    }
}
