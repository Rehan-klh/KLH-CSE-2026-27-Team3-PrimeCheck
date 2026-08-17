import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class MillerRabin {

    private static final SecureRandom random = new SecureRandom();

    public static boolean isPrime(BigInteger n, int iterations) {

        // Numbers less than 2 are not prime
        if (n.compareTo(BigInteger.TWO) < 0) {
            return false;
        }

        // 2 is prime
        if (n.equals(BigInteger.TWO)) {
            return true;
        }

        // Even numbers greater than 2 are composite
        if (n.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            return false;
        }

        // Write n - 1 as d * 2^r
        BigInteger d = n.subtract(BigInteger.ONE);
        int r = 0;

        while (d.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            d = d.divide(BigInteger.TWO);
            r++;
        }

        // Miller-Rabin iterations
        for (int i = 0; i < iterations; i++) {

            // Choose random base a where 2 <= a <= n - 2
            BigInteger a = randomBase(n);

            // x = a^d mod n
            BigInteger x = a.modPow(d, n);

            // If x = 1 or n - 1, this round passes
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

            // Composite
            if (!passed) {
                return false;
            }
        }

        // Probably prime
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

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("     LARGE PRIME VALIDATOR");
        System.out.println("     Miller-Rabin Test");
        System.out.println("=================================");

        System.out.print("Enter a number: ");
        BigInteger number = scanner.nextBigInteger();

        System.out.print("Enter number of iterations: ");
        int iterations = scanner.nextInt();

        long start = System.nanoTime();

        boolean result = isPrime(number, iterations);

        long end = System.nanoTime();

        double executionTime = (end - start) / 1_000_000.0;

        System.out.println();
        System.out.println("Number       : " + number);
        System.out.println("Bit Length   : " + number.bitLength());
        System.out.println("Iterations   : " + iterations);

        if (result) {
            System.out.println("Result       : PROBABLY PRIME");
        } else {
            System.out.println("Result       : COMPOSITE");
        }

        System.out.printf("Execution    : %.6f ms%n", executionTime);

        scanner.close();
    }
}