package com.primetest.algorithm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelPrimeTester {

    /**
     * Runs independent Miller-Rabin tests in parallel.
     * This is an experimental extension for the project.
     */
    public boolean test(BigInteger n, int iterations, int workers) {
        if (workers < 1) {
            throw new IllegalArgumentException("Workers must be at least 1.");
        }

        int actualWorkers = Math.min(workers, iterations);
        ExecutorService executor = Executors.newFixedThreadPool(actualWorkers);

        try {
            List<Callable<Boolean>> tasks = new ArrayList<>();

            for (int i = 0; i < iterations; i++) {
                tasks.add(() -> new MillerRabin().isProbablyPrime(n, 1));
            }

            List<Future<Boolean>> results = executor.invokeAll(tasks);

            for (Future<Boolean> result : results) {
                if (!result.get()) {
                    return false;
                }
            }

            return true;
        } catch (Exception e) {
            throw new RuntimeException("Parallel test failed.", e);
        } finally {
            executor.shutdown();
        }
    }
}
