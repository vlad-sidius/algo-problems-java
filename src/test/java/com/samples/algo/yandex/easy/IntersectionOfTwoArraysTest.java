package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IntersectionOfTwoArraysTest {

  private final IntersectionOfTwoArrays instance = new IntersectionOfTwoArrays();

  @Test
  void testSingleValueIntersection() {
    int[] nums1 = new int[] { 1,2,2,1 };
    int[] nums2 = new int[] { 2,2 };
    int[] expected = new int[] { 2 };

    int[] actual = instance.intersection(nums1, nums2);

    assertThat(actual).containsExactlyInAnyOrder(expected);
  }

  @Test
  void testMultiValuesIntersection() {
    int[] nums1 = new int[] { 4,9,5 };
    int[] nums2 = new int[] { 9,4,9,8,4 };
    int[] expected = new int[] { 9,4 };

    int[] actual = instance.intersection(nums1, nums2);

    assertThat(actual).containsExactlyInAnyOrder(expected);
  }
}
