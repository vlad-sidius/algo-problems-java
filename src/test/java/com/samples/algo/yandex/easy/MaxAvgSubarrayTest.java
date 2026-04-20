package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MaxAvgSubarrayTest {

  private final MaxAvgSubarray instance = new MaxAvgSubarray();

  @Test
  void testBaseCase() {
    int[] array = new int[] { 1,12,-5,-6,50,3 };
    int k = 4;
    double expected = 12.75000;

    double actual = instance.findMaxAverage(array, k);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testSingleValue() {
    int[] array = new int[] { 5 };
    int k = 1;
    double expected = 5.00000;

    double actual = instance.findMaxAverage(array, k);

    assertThat(actual).isEqualTo(expected);
  }

  // 0,1,1,3,3

  @Test
  void testFailedCase() {
    int[] array = new int[] { 0,1,1,3,3 };
    int k = 4;
    double expected = 2.00000;

    double actual = instance.findMaxAverage(array, k);

    assertThat(actual).isEqualTo(expected);
  }
}
