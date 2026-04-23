package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LongestContinuousIncreasingSubsequenceTest {

  private final LongestContinuousIncreasingSubsequence instance = new LongestContinuousIncreasingSubsequence();

  @Test
  void testFoundSubsequence1() {
    int[] nums = new int[] { 1,3,5,4,7 };
    int expected = 3;

    int actual = instance.findLengthOfLCIS(nums);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testFoundSubsequence2() {
    int[] nums = new int[] { 2,2,2,2,2 };
    int expected = 1;

    int actual = instance.findLengthOfLCIS(nums);

    assertThat(actual).isEqualTo(expected);
  }
}
