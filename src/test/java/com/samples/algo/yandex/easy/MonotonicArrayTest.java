package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MonotonicArrayTest {

  private final MonotonicArray instance = new MonotonicArray();

  @Test
  void testIncreaseCase() {
    int[] nums = new int[] { 1,2,2,3 };
    boolean actual = instance.isMonotonic(nums);

    assertThat(actual).isTrue();
  }

  @Test
  void testDecreaseCase() {
    int[] nums = new int[] { 6,5,4,4 };
    boolean actual = instance.isMonotonic(nums);

    assertThat(actual).isTrue();
  }

  @Test
  void testFailedCase() {
    int[] nums = new int[] { 1,3,2 };
    boolean actual = instance.isMonotonic(nums);

    assertThat(actual).isFalse();
  }
}
