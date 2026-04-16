package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MergeSortedArrayTest {

  private final MergeSortedArray mergeSortedArray = new MergeSortedArray();

  @Test
  void testBasicMerge() {
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {2, 5, 6};
    mergeSortedArray.merge(nums1, 3, nums2, 3);
    assertThat(nums1).containsExactly(1, 2, 2, 3, 5, 6);
  }

  @Test
  void testEmptySecondArray() {
    int[] nums1 = {1, 2, 3};
    int[] nums2 = {};
    mergeSortedArray.merge(nums1, 3, nums2, 0);
    assertThat(nums1).containsExactly(1, 2, 3);
  }

  @Test
  void testEmptyFirstArray() {
    int[] nums1 = {0};
    int[] nums2 = {1};
    mergeSortedArray.merge(nums1, 0, nums2, 1);
    assertThat(nums1).containsExactly(1);
  }

  @Test
  void testBothSingleElements() {
    int[] nums1 = {2, 0};
    int[] nums2 = {1};
    mergeSortedArray.merge(nums1, 1, nums2, 1);
    assertThat(nums1).containsExactly(1, 2);
  }

  @Test
  void testAllElementsFromSecondArraySmaller() {
    int[] nums1 = {4, 5, 6, 0, 0, 0};
    int[] nums2 = {1, 2, 3};
    mergeSortedArray.merge(nums1, 3, nums2, 3);
    assertThat(nums1).containsExactly(1, 2, 3, 4, 5, 6);
  }

  @Test
  void testAllElementsFromFirstArraySmaller() {
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {4, 5, 6};
    mergeSortedArray.merge(nums1, 3, nums2, 3);
    assertThat(nums1).containsExactly(1, 2, 3, 4, 5, 6);
  }

  @Test
  void testInterleavedElements() {
    int[] nums1 = {1, 3, 5, 0, 0, 0};
    int[] nums2 = {2, 4, 6};
    mergeSortedArray.merge(nums1, 3, nums2, 3);
    assertThat(nums1).containsExactly(1, 2, 3, 4, 5, 6);
  }

  @Test
  void testDuplicateElements() {
    int[] nums1 = {1, 2, 2, 0, 0};
    int[] nums2 = {2, 3};
    mergeSortedArray.merge(nums1, 3, nums2, 2);
    assertThat(nums1).containsExactly(1, 2, 2, 2, 3);
  }

  @Test
  void testNegativeNumbers() {
    int[] nums1 = {-3, -1, 0, 0, 0};
    int[] nums2 = {-2, 1};
    mergeSortedArray.merge(nums1, 3, nums2, 2);
    assertThat(nums1).containsExactly(-3, -2, -1, 0, 1);
  }

  @Test
  void testMixedPositiveAndNegative() {
    int[] nums1 = {-2, 0, 0, 0, 0};
    int[] nums2 = {-3, -1, 3};
    mergeSortedArray.merge(nums1, 2, nums2, 3);
    assertThat(nums1).containsExactly(-3, -2, -1, 0, 3);
  }

  @Test
  void testZerosInArrays() {
    int[] nums1 = {0, 1, 2, 0, 0};
    int[] nums2 = {0, 3};
    mergeSortedArray.merge(nums1, 3, nums2, 2);
    assertThat(nums1).containsExactly(0, 0, 1, 2, 3);
  }

  @Test
  void testLargeArrays() {
    int[] nums1 = {1, 3, 5, 7, 9, 0, 0, 0, 0, 0};
    int[] nums2 = {2, 4, 6, 8, 10};
    mergeSortedArray.merge(nums1, 5, nums2, 5);
    assertThat(nums1).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
  }

  @Test
  void testIdenticalArrays() {
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {1, 2, 3};
    mergeSortedArray.merge(nums1, 3, nums2, 3);
    assertThat(nums1).containsExactly(1, 1, 2, 2, 3, 3);
  }
}
