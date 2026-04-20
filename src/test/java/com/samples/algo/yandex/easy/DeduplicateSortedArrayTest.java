package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DeduplicateSortedArrayTest {

  private final DeduplicateSortedArray instance = new DeduplicateSortedArray();

  @Test
  void testNoDuplicates() {
    int[] input = new int[] { 0,1,2,3,4 };
    int expectedCount = 5;

    int count = instance.removeDuplicates(input);

    assertThat(count).isEqualTo(expectedCount);
  }

  @Test
  void testSomeDuplicates() {
    int[] input = new int[] { 0,0,1,1,1,2,2,3,3,4 };
    int expectedCount = 5;

    int count = instance.removeDuplicates(input);

    assertThat(count).isEqualTo(expectedCount);
  }

  @Test
  void testAllDuplicates() {
    int[] input = new int[] { 1,1,1,1 };
    int expectedCount = 1;

    int count = instance.removeDuplicates(input);

    assertThat(count).isEqualTo(expectedCount);
  }

  @Test
  void testEmptyArray() {
    int[] input = new int[] {};
    int expectedCount = 0;

    int count = instance.removeDuplicates(input);

    assertThat(count).isEqualTo(expectedCount);
  }
}
