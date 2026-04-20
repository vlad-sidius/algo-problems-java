package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RemoveElementTest {

  private final RemoveElement instance = new RemoveElement();

  @Test
  void testHasValues1() {
    int[] array = new int[] { 3,2,2,3 };
    int value = 3;
    int expected = 2;

    int actual = instance.removeElement(array, value);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testHasValues2() {
    int[] array = new int[] { 0,1,2,2,3,0,4,2 };
    int value = 2;
    int expected = 5;

    int actual = instance.removeElement(array, value);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testNoValues() {
    int[] array = new int[] { 1,2,2,1 };
    int value = 3;
    int expected = 4;

    int actual = instance.removeElement(array, value);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testEmpty() {
    int[] array = new int[] {};
    int value = 3;
    int expected = 0;

    int actual = instance.removeElement(array, value);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testSingleValue() {
    int[] array = new int[] { 1 };
    int value = 1;
    int expected = 0;

    int actual = instance.removeElement(array, value);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testAllValue() {
    int[] array = new int[] { 3,3,3 };
    int value = 3;
    int expected = 0;

    int actual = instance.removeElement(array, value);

    assertThat(actual).isEqualTo(expected);
  }
}
