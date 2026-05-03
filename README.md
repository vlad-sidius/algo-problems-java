# Algo Problems Java

A Java-based project for learning and practicing algorithms, data structures, and sorting techniques.

## Tech Stack

- **Java 25**
- **Maven** for build management
- **JUnit 6** + **AssertJ** for testing

## Sorting Algorithms

| Algorithm | Implementation | Complexity |
|-----------|---------------|------------|
| Merge Sort (Top-Down) | `MergeSortImpl` | O(n log n) |
| Merge Sort (Bottom-Up) | `MergeSortBottomUpImpl` | O(n log n) |
| Quick Sort | `QuickSortImpl` | O(n log n) avg |
| Quick Sort (3-Way) | `QuickSort3WayImpl` | O(n log n) avg |
| Insertion Sort | `InsertionSortImpl` | O(n²) |
| Selection Sort | `SelectionSortImpl` | O(n²) |
| Shell Sort | `ShellSortImpl` | O(n log² n) |

## Getting Started

**Build:**
```bash
mvn clean compile
```

**Run Tests:**
```bash
mvn test
```
