package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("LeetCode 2956: Find Common Elements Between Two Arrays")
public class CommonElementsTwoArraysTest {

  private final CommonElementsTwoArrays instance = new CommonElementsTwoArrays();

  static Stream<Arguments> provideCases() {
    return Stream.of(
        Arguments.of(new int[]{2, 3, 2}, new int[]{1, 2}, new int[]{2, 1}),
        Arguments.of(new int[]{4, 3, 2, 3, 1}, new int[]{2, 2, 5, 2, 3, 6}, new int[]{3, 4}),
        Arguments.of(new int[]{2, 4, 4, 2}, new int[]{2, 4, 2, 2}, new int[]{4, 4}),
        Arguments.of(new int[]{1, 1, 1}, new int[]{2, 2, 2}, new int[]{0, 0}),
        Arguments.of(new int[]{5}, new int[]{5}, new int[]{1, 1}),
        Arguments.of(new int[]{10, 20, 30}, new int[]{30, 20, 10}, new int[]{3, 3})
    );
  }

  @ParameterizedTest(name = "nums1={0}, nums2={1} → expected={2}")
  @MethodSource("provideCases")
  void testFindIntersectionValues(int[] nums1, int[] nums2, int[] expected) {
    assertArrayEquals(expected, instance.findIntersectionValues(nums1, nums2));
  }

  @Test
  @DisplayName("Large input with all identical values")
  void testAllIdentical() {
    int[] arr = new int[100];
    java.util.Arrays.fill(arr, 42);
    assertArrayEquals(new int[]{100, 100}, instance.findIntersectionValues(arr, arr));
  }
}
