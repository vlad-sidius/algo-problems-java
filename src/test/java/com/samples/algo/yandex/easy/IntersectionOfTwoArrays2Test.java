package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IntersectionOfTwoArrays2Test {

  private final IntersectionOfTwoArrays2 instance = new IntersectionOfTwoArrays2();

  @Test
  void testIntersectCase1() {
    int[] nums1 = new int[] { 1,2,2,1 };
    int[] nums2 = new int[] { 2,2 };
    int[] expected = new int[] { 2,2 };

    int[] actual = instance.intersect(nums1, nums2);

    assertThat(actual).containsExactlyInAnyOrder(expected);
  }

  @Test
  void testIntersectCase2() {
    int[] nums1 = new int[] { 4,9,5 };
    int[] nums2 = new int[] { 9,4,9,8,4 };
    int[] expected = new int[] { 9,4 };

    int[] actual = instance.intersect(nums1, nums2);

    assertThat(actual).containsExactlyInAnyOrder(expected);
  }
}
