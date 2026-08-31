import java.math.BigInteger;
import java.security.SecureRandom;

public class MillerRabin {

    private static final SecureRandom random = new SecureRandom();

    public static boolean isProbablyPrime(BigInteger n, int iterations) {

        if (n.compareTo(BigInteger.TWO) < 0)
            return false;

        if (n.equals(BigInteger.TWO))
            return true;

        if (n.mod(BigInteger.TWO).equals(BigInteger.ZERO))
            return false;

        BigInteger d = n.subtract(BigInteger.ONE);
        int r = 0;

        while (d.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            d = d.divide(BigInteger.TWO);
            r++;
        }

        for (int i = 0; i < iterations; i++) {

            BigInteger a;

            do {
                a = new BigInteger(n.bitLength(), random);
            } while (a.compareTo(BigInteger.TWO) < 0 ||
                     a.compareTo(n.subtract(BigInteger.TWO)) > 0);

            BigInteger x = a.modPow(d, n);

            if (x.equals(BigInteger.ONE) ||
                x.equals(n.subtract(BigInteger.ONE))) {
                continue;
            }

            boolean passed = false;

            for (int j = 0; j < r - 1; j++) {

                x = x.multiply(x).mod(n);

                if (x.equals(n.subtract(BigInteger.ONE))) {
                    passed = true;
                    break;
                }
            }

            if (!passed)
                return false;
        }

        return true;
    }
}