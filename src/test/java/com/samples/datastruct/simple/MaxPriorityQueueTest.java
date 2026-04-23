package com.samples.datastruct.simple;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("MaxPriorityQueue Interface Contract Tests")
public class MaxPriorityQueueTest {

  private MaxPriorityQueue<Integer> pq;

  @BeforeEach
  void setUp() {
    pq = new MaxPriorityQueueImpl<>(15);
  }

  @Nested
  @DisplayName("When queue is empty")
  class EmptyStateTests {

    @Test
    void shouldReportAsEmptyAndSizeZero() {
      assertAll("Initial state validation",
          () -> assertTrue(pq.isEmpty(), "New queue must be empty"),
          () -> assertEquals(0, pq.size(), "New queue size must be 0")
      );
    }

    @Test
    void maxShouldThrowException() {
      assertThrows(NoSuchElementException.class, pq::max,
          "max() on empty queue should throw NoSuchElementException");
    }

    @Test
    void delMaxShouldThrowException() {
      assertThrows(NoSuchElementException.class, pq::delMax,
          "delMax() on empty queue should throw NoSuchElementException");
    }
  }

  @Nested
  @DisplayName("When inserting elements")
  class InsertionTests {

    @Test
    void singleInsertUpdatesStateCorrectly() {
      pq.insert(42);
      assertAll("After single insertion",
          () -> assertFalse(pq.isEmpty()),
          () -> assertEquals(1, pq.size())
      );
    }

    @ParameterizedTest(name = "Inserting {0} elements should increase size accordingly")
    @ValueSource(ints = {1, 5, 10, 25, 100})
    void insertMultipleElementsIncreasesSize(int count) {
      for (int i = 0; i < count; i++) {
        pq.insert(i);
      }
      assertEquals(count, pq.size());
      assertFalse(pq.isEmpty());
    }
  }

  @Nested
  @DisplayName("When retrieving and removing maximum elements")
  class MaxOperationsTests {

    @Test
    void maxReturnsLargestWithoutRemovingIt() {
      pq.insert(5);
      pq.insert(10);
      pq.insert(3);
      pq.insert(7);

      assertEquals(10, pq.max());
      assertEquals(4, pq.size(), "max() must be read-only");
    }

    @Test
    void delMaxRemovesAndReturnsLargest() {
      pq.insert(5);
      pq.insert(10);
      pq.insert(3);

      assertEquals(10, pq.delMax());
      assertEquals(2, pq.size());
      assertEquals(5, pq.max(), "Next max should be 5 after removing 10");
    }

    @Test
    void delMaxUntilEmptyReturnsElementsInStrictDescendingOrder() {
      Integer[] input = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
      Arrays.stream(input).forEach(pq::insert);

      Integer[] expectedOutput = {16, 14, 10, 9, 8, 7, 4, 3, 2, 1};
      int index = 0;
      while (!pq.isEmpty()) {
        assertEquals(expectedOutput[index], pq.delMax());
        index++;
      }
      assertTrue(pq.isEmpty());
      assertEquals(0, pq.size());
    }
  }

  @Nested
  @DisplayName("When handling edge cases & duplicates")
  class EdgeCaseTests {

    @Test
    void handlesDuplicateMaxValuesCorrectly() {
      pq.insert(10);
      pq.insert(10);
      pq.insert(5);

      assertEquals(10, pq.max());
      assertEquals(10, pq.delMax());
      assertEquals(10, pq.max(), "Second duplicate max should still be retrievable");
      assertEquals(2, pq.size());
    }

    @Test
    void worksCorrectlyWithNegativeNumbers() {
      pq.insert(-5);
      pq.insert(-1);
      pq.insert(-10);

      assertEquals(-1, pq.max());
      assertEquals(-1, pq.delMax());
      assertEquals(-5, pq.delMax());
      assertEquals(-10, pq.delMax());
      assertTrue(pq.isEmpty());
    }

    // Optional: Add if your implementation rejects nulls
    @Test
    void insertNullThrowsException() {
      assertThrows(NullPointerException.class, () -> pq.insert(null),
          "PQ should reject null insertions");
    }
  }
}
