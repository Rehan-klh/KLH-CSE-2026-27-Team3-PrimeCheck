package com.primetest.algorithm;

import java.math.BigInteger;

public class NaivePrimeCheck {

    private static final BigInteger TWO = BigInteger.valueOf(2);

    /**
     * Deterministic trial-division baseline.
     * Intended for comparison and experimentation, not for very large inputs.
     */
    public boolean isPrime(BigInteger n) {
        if (n.compareTo(TWO) < 0) {
            return false;
        }

        if (n.equals(TWO)) {
            return true;
        }

        if (n.mod(TWO).equals(BigInteger.ZERO)) {
            return false;
        }

        BigInteger divisor = BigInteger.valueOf(3);
        while (divisor.multiply(divisor).compareTo(n) <= 0) {
            if (n.mod(divisor).equals(BigInteger.ZERO)) {
                return false;
            }
            divisor = divisor.add(TWO);
        }

        return true;
    }
}
