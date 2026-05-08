package com.samples.algo.yandex.interview;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Longest Strictly Monotonic Subarray")
class MaxMonotonicSubarrayTest {

  private final MaxMonotonicSubarray instance = new MaxMonotonicSubarray();

  static Stream<Arguments> provideCases() {
    return Stream.of(
        Arguments.of(new int[] { 2, 7, 5, 4, 4, 3 }, new int[] { 1, 3 }),
        Arguments.of(new int[] { 1, 1 }, new int[] { 0, 0 }),
        Arguments.of(new int[] { 1, 2, 3, 4 }, new int[] { 0, 3 }),
        Arguments.of(new int[] { 4, 3, 2, 1 }, new int[] { 0, 3 }),
        Arguments.of(new int[] { 1, 2, 2, 3 }, new int[] { 0, 1 }), // [1,2] or [2,3]
        Arguments.of(new int[] { 5 }, new int[] { 0, 0 }),
        Arguments.of(new int[] {}, new int[0]),
        Arguments.of(new int[] { 1, 3, 2, 4, 3, 5 }, new int[] { 0, 1 }), // first [1,3]
        Arguments.of(new int[] { -5, -3, -1, 0, -2 }, new int[] { 0, 3 }) // [-5,-3,-1,0]
    );
  }

  @ParameterizedTest(name = "a={0} → expected={1}")
  @MethodSource("provideCases")
  void testMaxMonotonic(int[] a, int[] expected) {
    int[] result = instance.maxMonotonic(a);
    assertArrayEquals(expected, result);
  }
}
