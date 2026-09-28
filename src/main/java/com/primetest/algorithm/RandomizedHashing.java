package com.primetest.algorithm;

import java.math.BigInteger;
import java.util.Random;

/**
 * Simple educational randomized hashing demonstration.
 * This is an extension module, separate from Miller-Rabin.
 */
public class RandomizedHashing {

    private final Random random = new Random();

    public int hash(BigInteger value, int tableSize) {
        if (tableSize <= 0) {
            throw new IllegalArgumentException("Table size must be positive.");
        }

        int randomMultiplier = 1 + random.nextInt(Math.max(1, tableSize - 1));
        int valueHash = value.hashCode() & 0x7fffffff;

        return (int) (((long) randomMultiplier * valueHash) % tableSize);
    }
}
