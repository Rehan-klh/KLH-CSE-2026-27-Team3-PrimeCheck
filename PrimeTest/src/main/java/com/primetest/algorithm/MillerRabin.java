package com.primetest.algorithm;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Hand-built Miller-Rabin probabilistic primality test.
 *
 * The class deliberately does not call BigInteger.isProbablePrime().
 */
public class MillerRabin {

    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger THREE = BigInteger.valueOf(3);

    private final SecureRandom random;

    public MillerRabin() {
        this.random = new SecureRandom();
    }

    public MillerRabin(SecureRandom random) {
        this.random = random;
    }

    public boolean isProbablyPrime(BigInteger n, int iterations) {
        if (iterations < 1) {
            throw new IllegalArgumentException("Iterations must be at least 1.");
        }

        if (n.compareTo(TWO) < 0) {
            return false;
        }

        if (n.equals(TWO) || n.equals(THREE)) {
            return true;
        }

        if (n.mod(TWO).equals(BigInteger.ZERO)) {
            return false;
        }

        // Write n - 1 = d * 2^s, where d is odd.
        BigInteger d = n.subtract(BigInteger.ONE);
        int s = 0;

        while (d.mod(TWO).equals(BigInteger.ZERO)) {
            d = d.divide(TWO);
            s++;
        }

        for (int i = 0; i < iterations; i++) {
            BigInteger a = randomBase(n);
            BigInteger x = a.modPow(d, n);

            if (x.equals(BigInteger.ONE) || x.equals(n.subtract(BigInteger.ONE))) {
                continue;
            }

            boolean witnessPassed = false;

            for (int r = 1; r < s; r++) {
                x = x.multiply(x).mod(n);

                if (x.equals(n.subtract(BigInteger.ONE))) {
                    witnessPassed = true;
                    break;
                }

                if (x.equals(BigInteger.ONE)) {
                    return false;
                }
            }

            if (!witnessPassed) {
                return false;
            }
        }

        return true;
    }

    private BigInteger randomBase(BigInteger n) {
        // 2 <= a <= n - 2
        BigInteger upper = n.subtract(THREE);

        if (upper.compareTo(TWO) < 0) {
            return TWO;
        }

        BigInteger a;
        do {
            a = new BigInteger(upper.bitLength(), random);
        } while (a.compareTo(TWO) < 0 || a.compareTo(upper) > 0);

        return a;
    }

    /**
     * For the standard independent-witness Miller-Rabin bound:
     * false-prime probability is at most (1/4)^k for odd composite n,
     * under the usual theorem assumptions.
     */
    public double errorProbabilityUpperBound(int iterations) {
        if (iterations < 1) {
            throw new IllegalArgumentException("Iterations must be at least 1.");
        }
        return Math.pow(0.25, iterations);
    }

    public double confidencePercentage(int iterations) {
        return (1.0 - errorProbabilityUpperBound(iterations)) * 100.0;
    }
}
