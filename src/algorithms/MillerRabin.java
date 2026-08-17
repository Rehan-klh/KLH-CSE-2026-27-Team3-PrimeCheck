package algorithms;

import java.math.BigInteger;
import java.security.SecureRandom;

public class MillerRabin {

    private static final SecureRandom random = new SecureRandom();

    public static boolean isProbablyPrime(BigInteger n, int iterations) {

        // 1. Numbers smaller than 2 are not prime
        if (n.compareTo(BigInteger.TWO) < 0) {
            return false;
        }

        // 2. 2 is prime
        if (n.equals(BigInteger.TWO)) {
            return true;
        }

        // 3. Even numbers greater than 2 are composite
        if (n.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            return false;
        }

        /*
         * Write:
         *
         * n - 1 = d × 2^r
         *
         * where d is odd.
         */

        BigInteger d = n.subtract(BigInteger.ONE);
        int r = 0;

        while (d.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            d = d.divide(BigInteger.TWO);
            r++;
        }

        // 4. Perform Miller-Rabin iterations
        for (int i = 0; i < iterations; i++) {

            // Choose random witness a
            BigInteger a = randomBase(n);

            // x = a^d mod n
            BigInteger x = a.modPow(d, n);

            // First condition
            if (x.equals(BigInteger.ONE)
                    || x.equals(n.subtract(BigInteger.ONE))) {
                continue;
            }

            boolean witnessPassed = false;

            // Square x repeatedly
            for (int j = 0; j < r - 1; j++) {

                x = x.multiply(x).mod(n);

                if (x.equals(n.subtract(BigInteger.ONE))) {
                    witnessPassed = true;
                    break;
                }
            }

            // This witness proves n is composite
            if (!witnessPassed) {
                return false;
            }
        }

        // No witness proved it composite
        return true;
    }

    private static BigInteger randomBase(BigInteger n) {

        BigInteger min = BigInteger.TWO;
        BigInteger max = n.subtract(BigInteger.TWO);

        BigInteger a;

        do {
            a = new BigInteger(n.bitLength(), random);
        } while (a.compareTo(min) < 0 || a.compareTo(max) > 0);

        return a;
    }
}