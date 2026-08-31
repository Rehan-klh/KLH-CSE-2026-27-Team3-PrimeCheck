import java.math.BigInteger;

public class PrimeAnalyzer {

    public static void analyze(BigInteger number, int iterations) {

        System.out.println();
        /*System.out.println("======================================");
        System.out.println("           PRIME ANALYSIS");
        System.out.println("======================================");*/

        System.out.println("Number     : " + number);
        System.out.println("Bit Length : " + number.bitLength());

        // Traditional Method
        long naiveStart = System.nanoTime();

        boolean naiveResult = NaivePrimeCheck.isPrime(number);

        long naiveEnd = System.nanoTime();

        double naiveTime =
                (naiveEnd - naiveStart) / 1_000_000.0;

        System.out.println();
        System.out.println("----- Traditional Method -----");
        System.out.println("Result : " +
                (naiveResult ? "PRIME" : "COMPOSITE"));

        System.out.printf("Time   : %.6f ms%n", naiveTime);


        // Miller-Rabin
        long mrStart = System.nanoTime();

        boolean mrResult =
                MillerRabin.isProbablyPrime(number, iterations);

        long mrEnd = System.nanoTime();

        double mrTime =
                (mrEnd - mrStart) / 1_000_000.0;

        System.out.println();
        System.out.println("----- Miller-Rabin -----");
        System.out.println("Result : " +
                (mrResult ? "PROBABLY PRIME" : "COMPOSITE"));

        System.out.println("Iterations : " + iterations);

        System.out.printf("Time   : %.6f ms%n", mrTime);


        // Comparison
        System.out.println();
        System.out.println("----- Comparison -----");

        if (naiveTime > mrTime) {

            double speedup = naiveTime / mrTime;

            System.out.printf(
                    "Miller-Rabin was %.2fx faster.%n",
                    speedup
            );

        } else {

            double speedup = mrTime / naiveTime;

            System.out.printf(
                    "Traditional method was %.2fx faster.%n",
                    speedup
            );
        }

        System.out.println("======================================");
    }
}