package com.primetest.algorithm;

import java.math.BigInteger;
import java.security.SecureRandom;

public class PrimeGenerator {

    private final SecureRandom random;
    private final MillerRabin millerRabin;

    public PrimeGenerator() {
        this.random = new SecureRandom();
        this.millerRabin = new MillerRabin(random);
    }

    public BigInteger generateProbablePrime(int bitLength, int iterations) {
        if (bitLength < 2) {
            throw new IllegalArgumentException("Bit length must be at least 2.");
        }
        if (iterations < 1) {
            throw new IllegalArgumentException("Iterations must be at least 1.");
        }

        while (true) {
            BigInteger candidate = new BigInteger(bitLength, random);

            // Force exact bit length and oddness.
            candidate = candidate.setBit(bitLength - 1);
            candidate = candidate.setBit(0);

            if (millerRabin.isProbablyPrime(candidate, iterations)) {
                return candidate;
            }
        }
    }
}
