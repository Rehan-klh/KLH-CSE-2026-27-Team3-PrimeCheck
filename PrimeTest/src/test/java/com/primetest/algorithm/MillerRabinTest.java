package com.primetest.algorithm;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class MillerRabinTest {

    private final MillerRabin millerRabin = new MillerRabin();

    @Test
    void identifiesSmallPrimes() {
        assertTrue(millerRabin.isProbablyPrime(BigInteger.TWO, 10));
        assertTrue(millerRabin.isProbablyPrime(BigInteger.valueOf(3), 10));
        assertTrue(millerRabin.isProbablyPrime(BigInteger.valueOf(97), 10));
        assertTrue(millerRabin.isProbablyPrime(BigInteger.valueOf(1009), 10));
    }

    @Test
    void identifiesSmallComposites() {
        assertFalse(millerRabin.isProbablyPrime(BigInteger.ONE, 10));
        assertFalse(millerRabin.isProbablyPrime(BigInteger.valueOf(9), 10));
        assertFalse(millerRabin.isProbablyPrime(BigInteger.valueOf(100), 10));
        assertFalse(millerRabin.isProbablyPrime(BigInteger.valueOf(1024), 10));
    }

    @Test
    void confidenceIncreasesWithIterations() {
        double c1 = millerRabin.confidencePercentage(1);
        double c5 = millerRabin.confidencePercentage(5);
        double c10 = millerRabin.confidencePercentage(10);

        assertTrue(c5 > c1);
        assertTrue(c10 > c5);
    }
}
