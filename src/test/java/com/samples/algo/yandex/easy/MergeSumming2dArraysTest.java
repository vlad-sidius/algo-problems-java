package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("2570. Merge Two 2D Arrays by Summing Values")
public class MergeSumming2dArraysTest {

  private final MergeSumming2dArrays instance = new MergeSumming2dArrays();

  static Stream<Arguments> provideCases() {
    return Stream.of(
        Arguments.of(
            new int[][]{{1, 2}, {2, 3}, {4, 5}},
            new int[][]{{1, 4}, {3, 2}, {4, 1}},
            new int[][]{{1, 6}, {2, 3}, {3, 2}, {4, 6}}
        ),
        Arguments.of(
            new int[][]{{2, 4}, {3, 6}, {5, 5}},
            new int[][]{{1, 3}, {4, 3}},
            new int[][]{{1, 3}, {2, 4}, {3, 6}, {4, 3}, {5, 5}}
        ),
        Arguments.of(
            new int[][]{{1, 1}},
            new int[][]{{1, 1}},
            new int[][]{{1, 2}}
        ),
        Arguments.of(
            new int[][]{{1, 2}, {2, 3}},
            new int[][]{{3, 4}, {4, 5}},
            new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}
        )
    );
  }

  @ParameterizedTest(name = "nums1={0}, nums2={1}")
  @MethodSource("provideCases")
  void testMergeArrays(int[][] nums1, int[][] nums2, int[][] expected) {
    int[][] result = instance.mergeArrays(nums1, nums2);
    assertArrayEquals(expected, result);
  }
}
