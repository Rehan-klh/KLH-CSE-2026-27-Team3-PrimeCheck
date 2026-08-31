import java.math.BigInteger;

public class NaivePrimeCheck {

    public static boolean isPrime(BigInteger n) {

        if (n.compareTo(BigInteger.TWO) < 0) {
            return false;
        }

        if (n.equals(BigInteger.TWO)) {
            return true;
        }

        if (n.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            return false;
        }

        BigInteger divisor = BigInteger.valueOf(3);

        while (divisor.multiply(divisor).compareTo(n) <= 0) {

            if (n.mod(divisor).equals(BigInteger.ZERO)) {
                return false;
            }

            divisor = divisor.add(BigInteger.TWO);
        }

        return true;
    }
}