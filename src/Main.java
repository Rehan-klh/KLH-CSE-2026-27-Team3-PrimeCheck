import algorithms.MillerRabin;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("          PRIMEFORGE");
        System.out.println("   Large Prime Validation Platform");
        System.out.println("======================================");

        System.out.print("Enter a large integer: ");
        String input = scanner.nextLine().trim();

        BigInteger number;

        try {
            number = new BigInteger(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number.");
            scanner.close();
            return;
        }

        // 1024-bit limit from the project requirement
        if (number.bitLength() > 1024) {
            System.out.println("Error: Number exceeds the 1024-bit limit.");
            scanner.close();
            return;
        }

        System.out.print("Enter number of iterations: ");
        int iterations = scanner.nextInt();

        if (iterations <= 0) {
            System.out.println("Iterations must be greater than 0.");
            scanner.close();
            return;
        }

        long startTime = System.nanoTime();

        boolean result =
                MillerRabin.isProbablyPrime(number, iterations);

        long endTime = System.nanoTime();

        double executionTime =
                (endTime - startTime) / 1_000_000.0;

        System.out.println();
        System.out.println("------------- RESULT -------------");

        System.out.println("Number       : " + number);
        System.out.println("Bit Length   : " + number.bitLength());
        System.out.println("Iterations   : " + iterations);

        if (result) {
            System.out.println("Status       : PROBABLY PRIME");
        } else {
            System.out.println("Status       : COMPOSITE");
        }

        System.out.printf(
                "Execution    : %.6f ms%n",
                executionTime
        );

        System.out.println("----------------------------------");

        scanner.close();
    }
}