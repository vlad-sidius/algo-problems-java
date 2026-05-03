package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("LeetCode 2215: Find the Difference of Two Arrays")
public class DiffElementsTwoArraysTest {

  private final DiffElementsTwoArrays instance = new DiffElementsTwoArrays();

  static Stream<Arguments> provideCases() {
    return Stream.of(
        Arguments.of(new int[]{1, 2, 3}, new int[]{2, 4, 6}, List.of(1, 3), List.of(4, 6)),
        Arguments.of(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2}, List.of(3), List.of()),
        Arguments.of(new int[]{-10, -5, 0, 5}, new int[]{0, 5, 10}, List.of(-10, -5), List.of(10)),
        Arguments.of(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}, List.of(), List.of()),
        Arguments.of(new int[]{5}, new int[]{10}, List.of(5), List.of(10))
    );
  }

  @ParameterizedTest(name = "nums1={0}, nums2={1}")
  @MethodSource("provideCases")
  void testFindDifference(int[] nums1, int[] nums2, List<Integer> expected1, List<Integer> expected2) {
    List<List<Integer>> result = instance.findDifference(nums1, nums2);

    assertEquals(2, result.size());
    assertTrue(result.get(0).containsAll(expected1));
    assertTrue(result.get(0).size() == expected1.size()); // Exact match (no extra elements)
    assertTrue(result.get(1).containsAll(expected2));
    assertTrue(result.get(1).size() == expected2.size());
  }

  @Test
  @DisplayName("Large inputs with many duplicates")
  void testLargeDuplicates() {
    int[] a = new int[1000];
    int[] b = new int[1000];

    for (int i = 0; i < 1000; i++) {
      a[i] = i % 10;
      b[i] = i % 10 + 10;
    }

    List<List<Integer>> res = instance.findDifference(a, b);
    assertEquals(10, res.get(0).size());
    assertEquals(10, res.get(1).size());
  }
}
