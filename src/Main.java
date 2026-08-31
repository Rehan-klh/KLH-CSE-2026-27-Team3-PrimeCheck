import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /*System.out.println("======================================");
        System.out.println("             PRIME TEST");
        System.out.println("======================================");*/

        System.out.print("Enter a large integer: ");

        String input = scanner.nextLine().trim();

        BigInteger number;

        try {
            number = new BigInteger(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer.");
            scanner.close();
            return;
        }

        if (number.bitLength() > 1024) {
            System.out.println("Number exceeds the 1024-bit limit.");
            scanner.close();
            return;
        }

        System.out.print("Enter Miller-Rabin iterations: ");

        int iterations = scanner.nextInt();

        if (iterations <= 0) {
            System.out.println("Iterations must be greater than 0.");
            scanner.close();
            return;
        }

        PrimeAnalyzer.analyze(number, iterations);

        scanner.close();
    }
}