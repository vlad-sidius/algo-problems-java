package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BinarySearchTest {

  private final BinarySearch binarySearch = new BinarySearch();

  @Test
  void testBaseCase() {
    int[] nums = new int[] {-1,0,3,5,9,12};
    int target = 9;
    int expected = 4;

    int actual = binarySearch.search(nums, target);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testMissingTarget() {
    int[] nums = new int[] {-1,0,3,5,9,12};
    int target = 2;
    int expected = -1;

    int actual = binarySearch.search(nums, target);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testSingleElement() {
    int[] nums = new int[] {5};
    int target = 5;
    int expected = 0;

    int actual = binarySearch.search(nums, target);
    assertThat(actual).isEqualTo(expected);
  }
}
