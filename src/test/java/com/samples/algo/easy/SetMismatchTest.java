package com.samples.algo.easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SetMismatchTest {

  static Stream<Arguments> testCases() {
    return Stream.of(
        Arguments.of(new int[]{1, 2, 2, 4}, new int[]{2, 3}),
        Arguments.of(new int[]{1, 1, 2, 3}, new int[]{1, 4}),
        Arguments.of(new int[]{1, 2, 3, 3}, new int[]{3, 4}),
        Arguments.of(new int[]{2, 2, 3, 4}, new int[]{2, 1}),
        Arguments.of(new int[]{1, 2, 3, 3, 5}, new int[]{3, 4}),
        Arguments.of(new int[]{1, 2, 3, 4, 5, 5, 7, 8, 9, 10}, new int[]{5, 6}),
        Arguments.of(new int[]{1, 1}, new int[]{1, 2}),
        Arguments.of(new int[]{1, 2, 3, 4, 5, 5, 7}, new int[]{5, 6}),
        Arguments.of(new int[]{1, 2, 2, 4, 5}, new int[]{2, 3}),
        Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 6}, new int[]{6, 7}),
        Arguments.of(new int[]{1, 2, 2}, new int[]{2, 3})
    );
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void testFindErrorNumsWithSet(int[] nums, int[] expected) {
    assertArrayEquals(expected, SetMismatch.findErrorNumsWithSet(nums));
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void testFindErrorNumsWithMap(int[] nums, int[] expected) {
    assertArrayEquals(expected, SetMismatch.findErrorNumsWithMap(nums));
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void testFindErrorNumsInPlace(int[] nums, int[] expected) {
    assertArrayEquals(expected, SetMismatch.findErrorNumsInPlace(nums));
  }
}
