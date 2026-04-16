package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SummaryRangesTest {

  private final SummaryRanges summaryRanges = new SummaryRanges();

  @Test
  void testSimpleConsecutiveNumbers() {
    int[] nums = {0, 1, 2, 4, 5, 7};
    List<String> result = summaryRanges.summaryRanges(nums);
    assertEquals(List.of("0->2", "4->5", "7"), result);
  }

  @Test
  void testNonConsecutiveNumbers() {
    int[] nums = {0, 2, 3, 4, 6, 8, 9};
    List<String> result = summaryRanges.summaryRanges(nums);
    assertEquals(List.of("0", "2->4", "6", "8->9"), result);
  }

  @Test
  void testEmptyArray() {
    int[] nums = {};
    List<String> result = summaryRanges.summaryRanges(nums);
    assertEquals(List.of(), result);
  }

  @Test
  void testSingleElement() {
    int[] nums = {5};
    List<String> result = summaryRanges.summaryRanges(nums);
    assertEquals(List.of("5"), result);
  }

  @Test
  void testAllConsecutive() {
    int[] nums = {1, 2, 3, 4, 5};
    List<String> result = summaryRanges.summaryRanges(nums);
    assertEquals(List.of("1->5"), result);
  }

  @Test
  void testAllNonConsecutive() {
    int[] nums = {1, 3, 5, 7, 9};
    List<String> result = summaryRanges.summaryRanges(nums);
    assertEquals(List.of("1", "3", "5", "7", "9"), result);
  }

  @Test
  void testNegativeNumbers() {
    int[] nums = {-5, -4, -3, -1, 0, 1};
    List<String> result = summaryRanges.summaryRanges(nums);
    assertEquals(List.of("-5->-3", "-1->1"), result);
  }

  @Test
  void testMixedNegativeAndPositive() {
    int[] nums = {-3, -2, -1, 0, 1, 2, 3};
    List<String> result = summaryRanges.summaryRanges(nums);
    assertEquals(List.of("-3->3"), result);
  }

  @Test
  void testTwoElements() {
    int[] nums = {10, 20};
    List<String> result = summaryRanges.summaryRanges(nums);
    assertEquals(List.of("10", "20"), result);
  }

  @Test
  void testTwoConsecutiveElements() {
    int[] nums = {10, 11};
    List<String> result = summaryRanges.summaryRanges(nums);
    assertEquals(List.of("10->11"), result);
  }

  @Test
  void testLargeNumbers() {
    int[] nums = {1000, 1001, 1002, 2000, 2001};
    List<String> result = summaryRanges.summaryRanges(nums);
    assertEquals(List.of("1000->1002", "2000->2001"), result);
  }

  @Test
  void testNegativeToPositiveWithGaps() {
    int[] nums = {-10, -5, -4, -3, 0, 5, 6};
    List<String> result = summaryRanges.summaryRanges(nums);
    assertEquals(List.of("-10", "-5->-3", "0", "5->6"), result);
  }
}
