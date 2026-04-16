package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumTest {

  private final TwoSum twoSum = new TwoSum();

  @Test
  void testBasicCase() {
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    int[] result = twoSum.twoSum(nums, target);

    assertThat(result).contains(0, 1);
  }

  @Test
  void testNonAdjacentIndices() {
    int[] nums = {3, 2, 4};
    int target = 6;
    int[] result = twoSum.twoSum(nums, target);

    assertThat(result).contains(1, 2);
  }

  @Test
  void testNegativeNumbers() {
    int[] nums = {-1, -2, -3, -4, -5};
    int target = -8;
    int[] result = twoSum.twoSum(nums, target);

    assertThat(result).contains(2, 4);
  }

  @Test
  void testMixedPositiveAndNegative() {
    int[] nums = {-3, 4, 3, 90};
    int target = 0;
    int[] result = twoSum.twoSum(nums, target);

    assertThat(result).contains(0, 2);
  }

  @Test
  void testSameValueTwice() {
    int[] nums = {3, 3};
    int target = 6;
    int[] result = twoSum.twoSum(nums, target);

    assertThat(result).contains(0, 1);
  }

  @Test
  void testSmallArray() {
    int[] nums = {1, 2};
    int target = 3;
    int[] result = twoSum.twoSum(nums, target);

    assertThat(result).contains(0, 1);
  }

  @Test
  void testTargetWithFirstAndLast() {
    int[] nums = {5, 25, 30, 45, 50};
    int target = 55;
    int[] result = twoSum.twoSum(nums, target);

    assertThat(result).contains(1, 2);
  }

  @Test
  void testLargeNumbers() {
    int[] nums = {1000000, 500000, 1500000};
    int target = 2000000;
    int[] result = twoSum.twoSum(nums, target);

    assertThat(result).contains(1, 2);
  }

  @Test
  void testZeroValues() {
    int[] nums = {0, 0, 0, 0};
    int target = 0;
    int[] result = twoSum.twoSum(nums, target);

    assertThat(result).contains(0, 1);
  }

  @Test
  void testResultOrderDoesNotMatter() {
    int[] nums = {7, 2};
    int target = 9;
    int[] result = twoSum.twoSum(nums, target);

    assertThat(result).contains(0, 1);
  }
}
