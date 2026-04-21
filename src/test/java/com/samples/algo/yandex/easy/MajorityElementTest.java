package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MajorityElementTest {
  private final MajorityElement instance = new MajorityElement();

  @Test
  void testMajorityElementFound1() {
    int[] array = new int[] { 3,2,3 };
    int expected = 3;

    int actual = instance.majorityElement(array);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testMajorityElementFound2() {
    int[] array = new int[] { 2,2,1,1,1,2,2 };
    int expected = 2;

    int actual = instance.majorityElement(array);

    assertThat(actual).isEqualTo(expected);
  }
}
