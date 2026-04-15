package com.samples.datastruct.sorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SortingAlgorithmTest {

  static Stream<SortingAlgorithm<Integer>> sortingAlgorithms() {
    return Stream.of(
        new InsertionSortImpl<>(),
        new SelectionSortImpl<>(),
        new ShellSortImpl<>(),
        new MergeSortImpl<>(),
        new MergeSortBottomUpImpl<>(),
        new QuickSortImpl<>(),
        new QuickSort3WayImpl<>()
    );
  }

  @ParameterizedTest
  @MethodSource("sortingAlgorithms")
  void shouldSortEmptyArray(SortingAlgorithm<Integer> algorithm) {
    Integer[] array = {};

    algorithm.sort(array);

    assertThat(algorithm.isSorted(array)).isTrue();
    assertThat(array).isEmpty();
  }

  @ParameterizedTest
  @MethodSource("sortingAlgorithms")
  void shouldSortSingleElementArray(SortingAlgorithm<Integer> algorithm) {
    Integer[] array = {42};

    algorithm.sort(array);

    assertThat(algorithm.isSorted(array)).isTrue();
    assertThat(array).containsExactly(42);
  }

  @ParameterizedTest
  @MethodSource("sortingAlgorithms")
  void shouldSortTwoElementsArray(SortingAlgorithm<Integer> algorithm) {
    Integer[] array = {2, 1};

    algorithm.sort(array);

    assertThat(algorithm.isSorted(array)).isTrue();
    assertThat(array).containsExactly(1, 2);
  }

  @ParameterizedTest
  @MethodSource("sortingAlgorithms")
  void shouldSortTwoElementsAlreadySorted(SortingAlgorithm<Integer> algorithm) {
    Integer[] array = {1, 2};

    algorithm.sort(array);

    assertThat(algorithm.isSorted(array)).isTrue();
    assertThat(array).containsExactly(1, 2);
  }

  @ParameterizedTest
  @MethodSource("sortingAlgorithms")
  void shouldSortSmallArray(SortingAlgorithm<Integer> algorithm) {
    Integer[] array = {5, 2, 8, 1, 9};

    algorithm.sort(array);

    assertThat(algorithm.isSorted(array)).isTrue();
    assertThat(array).containsExactly(1, 2, 5, 8, 9);
  }

  @ParameterizedTest
  @MethodSource("sortingAlgorithms")
  void shouldSortReverseOrderArray(SortingAlgorithm<Integer> algorithm) {
    Integer[] array = {9, 7, 5, 3, 1};

    algorithm.sort(array);

    assertThat(algorithm.isSorted(array)).isTrue();
    assertThat(array).containsExactly(1, 3, 5, 7, 9);
  }

  @ParameterizedTest
  @MethodSource("sortingAlgorithms")
  void shouldSortAlreadySortedArray(SortingAlgorithm<Integer> algorithm) {
    Integer[] array = {1, 2, 3, 4, 5};

    algorithm.sort(array);

    assertThat(algorithm.isSorted(array)).isTrue();
    assertThat(array).containsExactly(1, 2, 3, 4, 5);
  }

  @ParameterizedTest
  @MethodSource("sortingAlgorithms")
  void shouldSortArrayWithDuplicates(SortingAlgorithm<Integer> algorithm) {
    Integer[] array = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};

    algorithm.sort(array);

    assertThat(algorithm.isSorted(array)).isTrue();
    assertThat(array).containsExactly(1, 1, 2, 3, 3, 4, 5, 5, 6, 9);
  }

  @ParameterizedTest
  @MethodSource("sortingAlgorithms")
  void shouldSortArrayWithAllDuplicates(SortingAlgorithm<Integer> algorithm) {
    Integer[] array = {5, 5, 5, 5, 5};

    algorithm.sort(array);

    assertThat(algorithm.isSorted(array)).isTrue();
    assertThat(array).containsExactly(5, 5, 5, 5, 5);
  }

  @ParameterizedTest
  @MethodSource("sortingAlgorithms")
  void shouldSortArrayWithNegativeNumbers(SortingAlgorithm<Integer> algorithm) {
    Integer[] array = {-3, -1, -4, -1, -5, -9, -2, -6};

    algorithm.sort(array);

    assertThat(algorithm.isSorted(array)).isTrue();
    assertThat(array).containsExactly(-9, -6, -5, -4, -3, -2, -1, -1);
  }

  @ParameterizedTest
  @MethodSource("sortingAlgorithms")
  void shouldSortArrayWithMixedPositiveAndNegative(SortingAlgorithm<Integer> algorithm) {
    Integer[] array = {-2, 3, -1, 5, 0, -3, 2, 1};

    algorithm.sort(array);

    assertThat(algorithm.isSorted(array)).isTrue();
    assertThat(array).containsExactly(-3, -2, -1, 0, 1, 2, 3, 5);
  }

  @ParameterizedTest
  @MethodSource("sortingAlgorithms")
  void shouldSortArrayWithZeros(SortingAlgorithm<Integer> algorithm) {
    Integer[] array = {0, 0, 0, 0};

    algorithm.sort(array);

    assertThat(algorithm.isSorted(array)).isTrue();
    assertThat(array).containsExactly(0, 0, 0, 0);
  }

  @ParameterizedTest
  @MethodSource("sortingAlgorithms")
  void shouldSortArrayWithZerosAndOtherValues(SortingAlgorithm<Integer> algorithm) {
    Integer[] array = {3, 0, -2, 0, 5, 0};

    algorithm.sort(array);

    assertThat(algorithm.isSorted(array)).isTrue();
    assertThat(array).containsExactly(-2, 0, 0, 0, 3, 5);
  }

  @ParameterizedTest
  @MethodSource("sortingAlgorithms")
  void shouldSortArrayWithMinAndMaxIntegers(SortingAlgorithm<Integer> algorithm) {
    Integer[] array = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

    algorithm.sort(array);

    assertThat(algorithm.isSorted(array)).isTrue();
    assertThat(array).containsExactly(Integer.MIN_VALUE, 0, Integer.MAX_VALUE);
  }

  @ParameterizedTest
  @MethodSource("sortingAlgorithms")
  void shouldSortLargerArray(SortingAlgorithm<Integer> algorithm) {
    Integer[] array = {64, 34, 25, 12, 22, 11, 90, 45, 78, 32, 56, 89, 1, 67, 23};

    algorithm.sort(array);

    assertThat(algorithm.isSorted(array)).isTrue();
    assertThat(array).containsExactly(1, 11, 12, 22, 23, 25, 32, 34, 45, 56, 64, 67, 78, 89, 90);
  }

  @ParameterizedTest
  @MethodSource("sortingAlgorithms")
  void shouldSortArrayWithSingleDuplicate(SortingAlgorithm<Integer> algorithm) {
    Integer[] array = {2, 2};

    algorithm.sort(array);

    assertThat(algorithm.isSorted(array)).isTrue();
    assertThat(array).containsExactly(2, 2);
  }

  @ParameterizedTest
  @MethodSource("sortingAlgorithms")
  void shouldSortArrayWithTwoElementsReverse(SortingAlgorithm<Integer> algorithm) {
    Integer[] array = {100, -100};

    algorithm.sort(array);

    assertThat(algorithm.isSorted(array)).isTrue();
    assertThat(array).containsExactly(-100, 100);
  }

  @ParameterizedTest
  @MethodSource("sortingAlgorithms")
  void shouldMaintainArrayLengthAfterSort(SortingAlgorithm<Integer> algorithm) {
    Integer[] array = {5, 3, 8, 4, 2, 9, 1, 7, 6};
    int originalLength = array.length;

    algorithm.sort(array);

    assertThat(array).hasSize(originalLength);
  }

  @ParameterizedTest
  @MethodSource("sortingAlgorithms")
  void shouldSortArrayContainingConsecutiveNumbers(SortingAlgorithm<Integer> algorithm) {
    Integer[] array = {10, 11, 9, 12, 8, 13, 7, 14, 6, 15};

    algorithm.sort(array);

    assertThat(algorithm.isSorted(array)).isTrue();
    assertThat(array).containsExactly(6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
  }

  @ParameterizedTest
  @MethodSource("sortingAlgorithms")
  void shouldSortThreeElementsArray(SortingAlgorithm<Integer> algorithm) {
    Integer[] array = {3, 1, 2};

    algorithm.sort(array);

    assertThat(algorithm.isSorted(array)).isTrue();
    assertThat(array).containsExactly(1, 2, 3);
  }

  @ParameterizedTest
  @MethodSource("sortingAlgorithms")
  void shouldSortThreeElementsAlreadySorted(SortingAlgorithm<Integer> algorithm) {
    Integer[] array = {1, 2, 3};

    algorithm.sort(array);

    assertThat(algorithm.isSorted(array)).isTrue();
    assertThat(array).containsExactly(1, 2, 3);
  }

  @ParameterizedTest
  @MethodSource("sortingAlgorithms")
  void shouldSortThreeElementsReverseSorted(SortingAlgorithm<Integer> algorithm) {
    Integer[] array = {3, 2, 1};

    algorithm.sort(array);

    assertThat(algorithm.isSorted(array)).isTrue();
    assertThat(array).containsExactly(1, 2, 3);
  }
}
