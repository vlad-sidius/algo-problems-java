package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SingleNumberTest {

  private final SingleNumber instance = new SingleNumber();

  @Test
  void testBaseCase1() {
    int[] array = new int[] { 2,2,1 };
    int expected = 1;

    int actual = instance.singleNumber(array);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testBaseCase2() {
    int[] array = new int[] { 4,1,2,1,2 }; // 1,1,2,2,4
    int expected = 4;

    int actual = instance.singleNumber(array);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testSingleElement() {
    int[] array = new int[] { 1 };
    int expected = 1;

    int actual = instance.singleNumber(array);

    assertThat(actual).isEqualTo(expected);
  }
}
