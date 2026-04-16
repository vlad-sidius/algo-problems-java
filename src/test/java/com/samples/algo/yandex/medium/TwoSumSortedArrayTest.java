package com.samples.algo.yandex.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumSortedArrayTest {

  private final TwoSumSortedArray twoSumSortedArray = new TwoSumSortedArray();

  @Test
  void testBasicCase() {
    int[] numbers = {2, 7, 11, 15};
    int target = 9;
    int[] result = twoSumSortedArray.twoSum(numbers, target);
    assertThat(result).containsExactly(1, 2);
  }

  @Test
  void testNonAdjacentIndices() {
    int[] numbers = {2, 3, 4};
    int target = 6;
    int[] result = twoSumSortedArray.twoSum(numbers, target);
    assertThat(result).containsExactly(1, 3);
  }

  @Test
  void testNegativeNumbers() {
    int[] numbers = {-5, -3, -1, 0, 2, 4};
    int target = -4;
    int[] result = twoSumSortedArray.twoSum(numbers, target);
    assertThat(result).containsExactly(2, 3);
  }

  @Test
  void testMixedPositiveAndNegative() {
    int[] numbers = {-3, -1, 0, 2, 5, 8};
    int target = 7;
    int[] result = twoSumSortedArray.twoSum(numbers, target);
    assertThat(result).containsExactly(2, 6);
  }

  @Test
  void testSameValueTwice() {
    int[] numbers = {3, 3, 5, 7};
    int target = 6;
    int[] result = twoSumSortedArray.twoSum(numbers, target);
    assertThat(result).containsExactly(1, 2);
  }

  @Test
  void testTwoElementsOnly() {
    int[] numbers = {1, 2};
    int target = 3;
    int[] result = twoSumSortedArray.twoSum(numbers, target);
    assertThat(result).containsExactly(1, 2);
  }

  @Test
  void testTargetWithFirstAndLast() {
    int[] numbers = {1, 5, 10, 15, 20};
    int target = 21;
    int[] result = twoSumSortedArray.twoSum(numbers, target);
    assertThat(result).containsExactly(1, 5);
  }

  @Test
  void testLargeNumbers() {
    int[] numbers = {500000, 1000000, 1500000};
    int target = 2000000;
    int[] result = twoSumSortedArray.twoSum(numbers, target);
    assertThat(result).containsExactly(1, 3);
  }

  @Test
  void testDuplicateElements() {
    int[] numbers = {1, 2, 2, 3, 4, 4, 5};
    int target = 8;
    int[] result = twoSumSortedArray.twoSum(numbers, target);
    assertThat(result).containsExactly(4, 7);
  }

  @Test
  void testConsecutiveElements() {
    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int target = 15;
    int[] result = twoSumSortedArray.twoSum(numbers, target);
    assertThat(result).containsExactly(6, 9);
  }

  @Test
  void testTargetNearEndOfArray() {
    int[] numbers = {1, 3, 5, 7, 9, 11, 13, 15};
    int target = 28;
    int[] result = twoSumSortedArray.twoSum(numbers, target);
    assertThat(result).containsExactly(7, 8);
  }
}
