package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseIntegerTest {

  private final ReverseInteger reverseInteger = new ReverseInteger();

  @Test
  void testPositiveNumber() {
    assertThat(reverseInteger.reverse(123)).isEqualTo(321);
  }

  @Test
  void testNegativeNumber() {
    assertThat(reverseInteger.reverse(-123)).isEqualTo(-321);
  }

  @Test
  void testZero() {
    assertThat(reverseInteger.reverse(0)).isEqualTo(0);
  }

  @Test
  void testNumberEndingWithZero() {
    assertThat(reverseInteger.reverse(120)).isEqualTo(21);
  }

  @Test
  void testSingleDigit() {
    assertThat(reverseInteger.reverse(5)).isEqualTo(5);
  }

  @Test
  void testNegativeSingleDigit() {
    assertThat(reverseInteger.reverse(-5)).isEqualTo(-5);
  }

  @Test
  void testOverflowPositive() {
    assertThat(reverseInteger.reverse(1534236469)).isEqualTo(0);
  }

  @Test
  void testOverflowNegative() {
    assertThat(reverseInteger.reverse(-1563847412)).isEqualTo(0);
  }

  @Test
  void testMaxInt() {
    assertThat(reverseInteger.reverse(Integer.MAX_VALUE)).isEqualTo(0);
  }

  @Test
  void testMinInt() {
    assertThat(reverseInteger.reverse(Integer.MIN_VALUE)).isEqualTo(0);
  }

  @Test
  void testPalindromeNumber() {
    assertThat(reverseInteger.reverse(121)).isEqualTo(121);
  }

  @Test
  void testNegativePalindrome() {
    assertThat(reverseInteger.reverse(-121)).isEqualTo(-121);
  }

  @Test
  void testTwoDigitNumber() {
    assertThat(reverseInteger.reverse(12)).isEqualTo(21);
  }

  @Test
  void testNegativeTwoDigit() {
    assertThat(reverseInteger.reverse(-21)).isEqualTo(-12);
  }
}
