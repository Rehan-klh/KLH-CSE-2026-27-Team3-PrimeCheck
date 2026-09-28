package com.primetest;

import com.primetest.algorithm.MillerRabin;
import com.primetest.algorithm.PrimeAnalyzer;
import com.primetest.model.PrimeAnalysisResult;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("              PRIMETEST");
        System.out.println("========================================");
        System.out.println("Large Prime Analysis & Validation");
        System.out.println();

        System.out.print("Enter a large integer: ");
        String input = scanner.nextLine().trim();

        if (!input.matches("[0-9]+")) {
            System.out.println("Invalid input. Please enter a non-negative integer.");
            return;
        }

        BigInteger number = new BigInteger(input);

        System.out.print("Enter Miller-Rabin iterations [10]: ");
        String iterationInput = scanner.nextLine().trim();

        int iterations = 10;
        if (!iterationInput.isEmpty()) {
            try {
                iterations = Integer.parseInt(iterationInput);
                if (iterations < 1) {
                    System.out.println("Iterations must be at least 1.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid iteration count.");
                return;
            }
        }

        PrimeAnalyzer analyzer = new PrimeAnalyzer();
        PrimeAnalysisResult result = analyzer.analyze(number, iterations);

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("              RESULT");
        System.out.println("----------------------------------------");
        System.out.println("Number       : " + number);
        System.out.println("Bit Length   : " + number.bitLength());
        System.out.println("Traditional  : " + result.traditionalResult());
        System.out.printf("Traditional Time: %.3f ms%n", result.traditionalTimeNanos() / 1_000_000.0);
        System.out.println("Miller-Rabin  : " + result.millerRabinResult());
        System.out.println("Iterations    : " + result.iterations());
        System.out.printf("MR Time       : %.3f ms%n", result.millerRabinTimeNanos() / 1_000_000.0);
        System.out.printf("Error Bound   : <= %.10e%n", result.errorProbabilityUpperBound());
        System.out.printf("Confidence    : >= %.10f%%%n", result.confidencePercentage());
        System.out.println("----------------------------------------");
    }
}
