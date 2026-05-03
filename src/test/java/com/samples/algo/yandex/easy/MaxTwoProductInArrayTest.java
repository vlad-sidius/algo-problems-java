package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 1464: Maximum Product of Two Elements")
public class MaxTwoProductInArrayTest {

  private final MaxTwoProductInArray instance = new MaxTwoProductInArray();

  static Stream<Arguments> testSource() {
    return Stream.of(
        Arguments.of(new int[] {3,4,5,2}, 12),
        Arguments.of(new int[] {1,5,4,5}, 16),
        Arguments.of(new int[] {3,7}, 12),
        Arguments.of(new int[] {10,10,10,10}, 81),
        Arguments.of(new int[] {2,2}, 1),
        Arguments.of(new int[] {1,1,1}, 0),
        Arguments.of(new int[] {999,1000}, 997002)
    );
  }

  @ParameterizedTest(name = "nums={0} → expected={1}")
  @MethodSource("testSource")
  void testMaxProduct(int[] nums, int expected) {
    assertEquals(expected, instance.maxProduct(nums));
  }

  @Test
  @DisplayName("Stress test: all identical values")
  void testAllIdentical() {
    int[] nums = new int[500];
    java.util.Arrays.fill(nums, 42);
    assertEquals(41 * 41, instance.maxProduct(nums));
  }
}
