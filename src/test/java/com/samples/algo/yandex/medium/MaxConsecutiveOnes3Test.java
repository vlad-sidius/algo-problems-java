package com.samples.algo.yandex.medium;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("1004. Max Consecutive Ones III")
public class MaxConsecutiveOnes3Test {

  private final MaxConsecutiveOnes3 instance = new MaxConsecutiveOnes3();

  static Stream<Arguments> provideCases() {
    return Stream.of(
        Arguments.of(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2, 6), // LC Example 1
        Arguments.of(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3, 10), // LC Example 2
        Arguments.of(new int[]{1, 1, 1, 1}, 0, 4),               // All 1s, k=0
        Arguments.of(new int[]{0, 0, 0, 0}, 2, 2),               // All 0s, limited k
        Arguments.of(new int[]{0, 0, 0, 0}, 4, 4),               // All 0s, k >= length
        Arguments.of(new int[]{1, 0, 1, 0, 1, 0, 1}, 1, 3),         // Alternating, k=1
        Arguments.of(new int[]{1}, 0, 1),                     // Single element
        Arguments.of(new int[]{0}, 1, 1)                      // Single 0, k=1
    );
  }

  @ParameterizedTest(name = "nums={0}, k={1} → expected={2}")
  @MethodSource("provideCases")
  void testLongestOnes(int[] nums, int k, int expected) {
    assertEquals(expected, instance.longestOnes(nums, k));
  }
}
