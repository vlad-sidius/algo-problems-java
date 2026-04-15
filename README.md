# Algo Problems Java

A Java-based project for learning and practicing algorithms, data structures, and sorting techniques.

## Tech Stack

- **Java 25**
- **Maven** for build management
- **JUnit 6** + **AssertJ** for testing

## Project Structure

```
src/main/java/com/samples/
├── algo/easy/                    # Basic algorithm implementations
│   ├── NumberPalindrome          # Check if a number is a palindrome
│   ├── StringPalindrome          # Check if a string is a palindrome
│   ├── SetMismatch               # Find duplicate and missing numbers in a set
│   └── ValidParentheses          # Validate balanced parentheses
│
├── datastruct/
│   ├── simple/                   # Core data structure implementations
│   │   ├── Queue                 # Queue interface
│   │   ├── ArrayQueue            # Array-based queue with resizing
│   │   ├── LinkedListQueue       # LinkedList-based queue
│   │   ├── Stack                 # Stack interface
│   │   ├── ArrayStack            # Array-based stack with resizing
│   │   ├── LinkedListStack       # LinkedList-based stack
│   │   └── Node                  # Generic linked list node
│   │
│   └── sorting/                  # Sorting algorithm implementations
│       ├── SortingAlgorithm      # Sorting interface
│       ├── BaseMergeSort         # Base merge sort utilities
│       ├── MergeSortImpl         # Top-down merge sort
│       ├── MergeSortBottomUpImpl # Bottom-up merge sort
│       ├── QuickSortImpl         # Quick sort
│       ├── QuickSort3WayImpl     # 3-way quick sort
│       ├── InsertionSortImpl     # Insertion sort
│       ├── SelectionSortImpl     # Selection sort
│       └── ShellSortImpl         # Shell sort
│
└── common/                       # Shared utilities
    └── Person                    # Utility model class
```

```
src/test/java/com/samples/
├── algo/easy/
│   ├── NumberPalindromeTest
│   ├── StringPalindromeTest
│   ├── SetMismatchTest
│   └── ValidParenthesesTest
│
└── datastruct/simple/
    ├── QueueTest
    ├── ArrayQueueResizeTest
    ├── StackTest
    └── ArrayStackResizeTest

src/test/java/com/samples/datastruct/sorting/
    └── SortingAlgorithmTest      # Unified test for all sorting algorithms
```

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
