package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxMonotonicSubarrayTest {

  static Stream<Arguments> testCases() {
    return Stream.of(
        Arguments.of(new int[]{1, 2, 3, 4}, 4),
        Arguments.of(new int[]{4, 3, 2, 1}, 4),
        Arguments.of(new int[]{2, 7, 5, 4, 4, 3}, 3),
        Arguments.of(new int[]{1, 1}, 1),
        Arguments.of(new int[]{5}, 1),
        Arguments.of(new int[]{1, 2, 2, 3}, 2),
        Arguments.of(new int[]{3, 2, 1, 1, 2}, 3),
        Arguments.of(new int[]{1, 2, 3, 2, 1}, 3),
        Arguments.of(new int[]{-5, -3, -1, 0}, 4),
        Arguments.of(new int[]{10, 5, 0, -5}, 4)
    );
  }

  private final MaxMonotonicSubarray instance = new MaxMonotonicSubarray();

  @ParameterizedTest(name = "input={0} → expected length={1}")
  @MethodSource("testCases")
  void testMonotonicLength(int[] array, int expected) {
    int result = instance.longestMonotonicSubarray(array);
    assertEquals(expected, result);
  }

  @Test
  @DisplayName("Empty array returns 0")
  void testEmptyArray() {
    assertEquals(0, instance.longestMonotonicSubarray(new int[]{}));
  }

  @Test
  @DisplayName("Null array returns 0")
  void testNullArray() {
    assertEquals(0, instance.longestMonotonicSubarray(null));
  }
}
