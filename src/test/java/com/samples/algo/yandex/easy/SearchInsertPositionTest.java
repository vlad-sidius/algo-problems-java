package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("35. Search Insert Position")
public class SearchInsertPositionTest {

  private final SearchInsertPosition instance = new SearchInsertPosition();

  static Stream<Arguments> provideCases() {
    return Stream.of(
        Arguments.of(new int[]{1, 3, 5, 6}, 5, 2),      // Exact match
        Arguments.of(new int[]{1, 3, 5, 6}, 2, 1),      // Insert between
        Arguments.of(new int[]{1, 3, 5, 6}, 7, 4),      // Insert after end
        Arguments.of(new int[]{1, 3, 5, 6}, 0, 0),      // Insert before start
        Arguments.of(new int[]{1}, 0, 0),                // Single element, insert before
        Arguments.of(new int[]{1}, 2, 1),                // Single element, insert after
        Arguments.of(new int[]{1, 3}, 2, 1),             // Even length, insert middle
        Arguments.of(new int[]{-10, -5, 0, 5}, -6, 1)   // Negative values
    );
  }

  @ParameterizedTest(name = "nums={0}, target={1} → expected={2}")
  @MethodSource("provideCases")
  void testSearchInsert(int[] nums, int target, int expected) {
    assertEquals(expected, instance.searchInsert(nums, target));
  }
}
