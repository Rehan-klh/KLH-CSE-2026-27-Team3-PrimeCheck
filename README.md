# PrimeForge: Large Prime Generation & Validation Platform

## Project Title

**PrimeForge: Large Prime Generation & Validation Platform**

## Team Members

| S. No. | Name         | Student ID |
| ------ | ------------ | ---------- |
| 1      | K. Sai Akhil | 2520030021 |
| 2      | Mohd. Rehan  | 2520030066 |
| 3      | T. Hasini    | 2520030102 |

## Supervisor

**Dr. Ch Anuradha**

---

## Abstract

PrimeForge is a web-based platform designed for the generation, validation, analysis, and performance evaluation of large prime numbers. The project focuses on probabilistic algorithm design, with the **Miller–Rabin Primality Test** serving as the core algorithm for efficiently determining whether very large integers are prime or composite with high probability.

The system is intended to support integers up to **1024 bits** and provide useful information such as the primality result, confidence level, number of iterations, and execution time. As the project progresses, the platform will be extended with large-prime generation, algorithm benchmarking, randomized hashing, reservoir sampling, parallel processing, and performance analysis. The overall objective is to demonstrate the practical application of advanced DSA concepts through an integrated web-based system.

---

## Project Objective

The main objective of PrimeForge is to develop a practical platform that demonstrates the use of **randomized and parallel algorithms** for large-scale computational problems.

The project will focus on:

* Efficient primality testing for very large integers.
* Implementation of the Miller–Rabin probabilistic algorithm.
* Analysis of confidence and execution time.
* Generation and analysis of large prime candidates.
* Comparison of algorithmic approaches.
* Application of randomized algorithm concepts.
* Investigation of parallel execution and scalability.
* Providing an interactive web-based interface.

---

## Planned Modules

### 1. Large Prime Validation

Validate very large integers using a self-implemented Miller–Rabin Primality Test.

### 2. Large Prime Generation

Generate large random prime candidates of different bit sizes and validate them using probabilistic testing.

### 3. Miller–Rabin Confidence Analysis

Study the relationship between the number of randomized iterations and the confidence of the primality result.

### 4. Algorithm Benchmarking

Measure execution time and performance for different input sizes and testing approaches.

### 5. Deterministic vs Randomized Testing

Compare probabilistic primality testing with suitable deterministic approaches where practical.

### 6. Randomized Hashing

Implement and demonstrate randomized hashing techniques as an additional randomized-algorithm component.

### 7. Reservoir Sampling

Implement reservoir sampling and demonstrate its behavior on streams of generated or tested values.

### 8. Parallel Prime Testing

Explore parallel execution of independent primality-test operations and evaluate performance and scalability.

### 9. Performance Dashboard

Provide a unified web interface for displaying primality results, confidence, execution time, generation statistics, and benchmarking results.

---

## Technology Stack

* **Programming Language:** Java
* **Backend:** Java / Spring Boot
* **Frontend:** HTML, CSS, JavaScript
* **Large Integer Support:** `java.math.BigInteger`
* **Core Algorithm:** Miller–Rabin Primality Test
* **Database:** Not required for the core system
* **Dataset:** Not required

---

## Project Requirements

The core system will:

* Accept large integer input.
* Support numbers up to 1024 bits.
* Determine whether an integer is prime or composite with high probability.
* Implement the Miller–Rabin Primality Test.
* Display the execution time.
* Display the confidence level of the result.
* Provide a web-based interface.
* Support further randomized and parallel algorithm modules as the project develops.

The algorithm implementations will be developed as part of the project rather than relying entirely on built-in primality-testing functionality.

---

## Setup and Execution

### Prerequisites

Install the following:

* Java JDK 17 or later
* Git
* A Java-compatible IDE such as IntelliJ IDEA, Eclipse, or VS Code
* Maven for the Spring Boot web application phase

### Clone the Repository

```bash
git clone https://github.com/Akhil-0715/klh-cse-2026-2027-Team3-PrimeCheck.git
```

Navigate into the project:

```bash
cd klh-cse-2026-2027-Team3-PrimeCheck
```

### Current Development Version

The project is currently in the initial setup and planning phase. The GitHub repository and project documentation are being established before the main implementation begins.

The Java algorithm implementation and web service will be added progressively during development.

---

## Current Phase & Status

**Current Phase:** Phase 1 — Project Setup and Planning

### Status

* [x] Project topic selected
* [x] Project title finalized
* [x] Git repository initialized
* [x] GitHub repository created
* [x] README documentation started
* [x] Project scope planned
* [x] Team members finalized
* [x] Supervisor finalized
* [ ] Project folder structure finalized
* [ ] Miller–Rabin implementation
* [ ] Confidence calculation
* [ ] Large-prime generation
* [ ] Benchmarking module
* [ ] Deterministic vs randomized comparison
* [ ] Randomized hashing module
* [ ] Reservoir sampling module
* [ ] Parallel prime testing
* [ ] Backend / REST API
* [ ] Frontend interface
* [ ] Performance dashboard
* [ ] Integration testing
* [ ] Final evaluation and documentation

---

## Development Roadmap

```text
Project Planning & Setup
          ↓
Miller–Rabin Implementation
          ↓
Confidence & Performance Analysis
          ↓
Large Prime Generation
          ↓
Algorithm Benchmarking
          ↓
Randomized Hashing
          ↓
Reservoir Sampling
          ↓
Parallel Prime Testing
          ↓
Java Web Service
          ↓
Frontend Development
          ↓
Performance Dashboard
          ↓
Integration & Testing
          ↓
Final Evaluation
```

---

## Expected Final Output

The completed platform is expected to provide:

* Large integer input up to 1024 bits.
* Prime / Composite classification.
* Miller–Rabin iteration count.
* Confidence level.
* Execution time.
* Large-prime generation.
* Algorithm performance comparisons.
* Randomized algorithm demonstrations.
* Parallel processing analysis.
* Interactive web-based visualization and reporting.

---

## Repository Structure

The project structure will evolve as development progresses.

Initial structure:

```text
klh-cse-2026-2027-Team3-PrimeCheck/
│
├── README.md
│
└── src/
    └── ...
```

The final structure will separate the algorithm engine, backend services, frontend components, testing, and documentation.

---

## Academic Focus

PrimeForge is developed as a **DSA-3 project** with emphasis on:

* Randomized algorithms
* Probabilistic correctness
* Large-integer computation
* Algorithm efficiency
* Performance analysis
* Parallel algorithms
* Scalability
* Practical algorithm implementation

The project will progressively expand from the core large-prime validation problem into a broader platform demonstrating the DSA concepts covered during the course.

---

## Project Status

**Current Status: 🟡 Initial Setup**

The repository has been initialized and the project documentation is being prepared. Algorithm development and the web application implementation will begin in the next development phase.
