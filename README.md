# PrimeTest — Large Prime Analysis & Validation Platform

PrimeTest is a Java DSA project for analyzing very large integers using randomized algorithms, with Miller–Rabin primality testing as the core algorithm.

## Current project goals

- Validate large integers up to 1024 bits.
- Implement Miller–Rabin without calling `BigInteger.isProbablePrime()`.
- Compare randomized primality testing with deterministic trial division.
- Measure execution time and input bit length.
- Study the effect of Miller–Rabin iterations on confidence/error probability.
- Generate large probable primes.
- Benchmark scalability.
- Provide a web interface using Spring Boot.
- Include extension modules for randomized hashing, reservoir sampling, and parallel testing.

## Technology

- Java 17+
- Maven
- Spring Boot 3.x
- `java.math.BigInteger` for large integer arithmetic
- No database required
- No dataset required

## Project structure

```text
PrimeTest/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   ├── java/com/primetest/
    │   │   ├── PrimeTestApplication.java
    │   │   ├── Main.java
    │   │   ├── algorithm/
    │   │   │   ├── MillerRabin.java
    │   │   │   ├── NaivePrimeCheck.java
    │   │   │   ├── PrimeAnalyzer.java
    │   │   │   ├── PrimeGenerator.java
    │   │   │   ├── ConfidenceAnalyzer.java
    │   │   │   ├── Benchmark.java
    │   │   │   ├── ParallelPrimeTester.java
    │   │   │   ├── RandomizedHashing.java
    │   │   │   └── ReservoirSampler.java
    │   │   ├── model/
    │   │   │   └── PrimeAnalysisResult.java
    │   │   └── web/
    │   │       └── PrimeController.java
    │   └── resources/static/
    │       └── index.html
    └── test/
        └── java/com/primetest/algorithm/
            └── MillerRabinTest.java
```

## Run the terminal version

```bash
mvn clean package
java -cp target/classes com.primetest.Main
```

Or run `Main.java` directly from VS Code/IntelliJ.

## Run the web version

```bash
mvn spring-boot:run
```

Then open:

```text
http://localhost:8080
```

## Important DSA note

The project implements the Miller–Rabin procedure itself. The application does not use `BigInteger.isProbablePrime()` as the primality engine.

Miller–Rabin returns `COMPOSITE` when a witness proves compositeness. If all selected witnesses pass, the result is reported as `PROBABLY PRIME`.

## Development stages

1. Core Miller–Rabin implementation
2. Deterministic comparison
3. Iterations and confidence/error analysis
4. Large-number testing
5. Prime generation
6. Benchmarking
7. Web interface
8. Randomized algorithm extensions
9. Parallel testing
10. Final experiments, documentation, and presentation

## Honest project status

This repository is a complete working baseline and scaffold for the project. The trimester experiments, benchmark tables, screenshots, and final report should be produced from your actual runs rather than invented in advance.
