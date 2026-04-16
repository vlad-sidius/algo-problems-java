package com.samples.algo.yandex.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindKClosestElementsTest {

  private final FindKClosestElements finder = new FindKClosestElements();

  @Test
  void testBasicCase() {
    int[] arr = {1, 2, 3, 4, 5};
    List<Integer> result = finder.findClosestElements(arr, 4, 3);
    assertEquals(List.of(1, 2, 3, 4), result);
  }

  @Test
  void testKEqualsArrayLength() {
    int[] arr = {1, 2, 3, 4, 5};
    List<Integer> result = finder.findClosestElements(arr, 5, 3);
    assertEquals(List.of(1, 2, 3, 4, 5), result);
  }

  @Test
  void testKEqualsOne() {
    int[] arr = {1, 2, 3, 4, 5};
    List<Integer> result = finder.findClosestElements(arr, 1, 3);
    assertEquals(List.of(3), result);
  }

  @Test
  void testXNotInArray() {
    int[] arr = {1, 2, 4, 5, 6};
    List<Integer> result = finder.findClosestElements(arr, 3, 3);
    assertEquals(List.of(1, 2, 4), result);
  }

  @Test
  void testXLessThanAllElements() {
    int[] arr = {1, 2, 3, 4, 5};
    List<Integer> result = finder.findClosestElements(arr, 2, 0);
    assertEquals(List.of(1, 2), result);
  }

  @Test
  void testXGreaterThanAllElements() {
    int[] arr = {1, 2, 3, 4, 5};
    List<Integer> result = finder.findClosestElements(arr, 2, 10);
    assertEquals(List.of(4, 5), result);
  }

  @Test
  void testTieBreakingByValue() {
    int[] arr = {1, 2, 3, 4, 5};
    List<Integer> result = finder.findClosestElements(arr, 2, 3);
    assertEquals(List.of(2, 3), result);
  }

  @Test
  void testNegativeNumbers() {
    int[] arr = {-5, -4, -3, -2, -1};
    List<Integer> result = finder.findClosestElements(arr, 3, -3);
    assertEquals(List.of(-4, -3, -2), result);
  }

  @Test
  void testMixedPositiveAndNegative() {
    int[] arr = {-10, -5, 0, 5, 10};
    List<Integer> result = finder.findClosestElements(arr, 3, 0);
    assertEquals(List.of(-5, 0, 5), result);
  }

  @Test
  void testSingleElementArray() {
    int[] arr = {1};
    List<Integer> result = finder.findClosestElements(arr, 1, 1);
    assertEquals(List.of(1), result);
  }

  @Test
  void testDuplicateElements() {
    int[] arr = {1, 1, 1, 2, 2, 3};
    List<Integer> result = finder.findClosestElements(arr, 4, 1);
    assertEquals(List.of(1, 1, 1, 2), result);
  }

  @Test
  void testLargeK() {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    List<Integer> result = finder.findClosestElements(arr, 8, 5);
    assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8), result);
  }

  @Test
  void testElementsAroundX() {
    int[] arr = {12, 16, 22, 30, 35, 40};
    List<Integer> result = finder.findClosestElements(arr, 3, 20);
    assertEquals(List.of(12, 16, 22), result);
  }

  @Test
  void testEvenDistanceTie() {
    int[] arr = {1, 5, 10, 15, 20};
    List<Integer> result = finder.findClosestElements(arr, 2, 12);
    assertEquals(List.of(10, 15), result);
  }

  @Test
  void testArrayWithZeros() {
    int[] arr = {-3, -2, -1, 0, 1, 2, 3};
    List<Integer> result = finder.findClosestElements(arr, 3, 0);
    assertEquals(List.of(-1, 0, 1), result);
  }

  @Test
  void testResultSortedAscending() {
    int[] arr = {10, 20, 30, 40, 50};
    List<Integer> result = finder.findClosestElements(arr, 3, 35);
    assertEquals(List.of(20, 30, 40), result);
  }
}
