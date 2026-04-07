package com.samples.algo.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberPalindromeTest {

  @Test
  void testPositivePalindrome() {
    assertTrue(NumberPalindrome.isPalindrome(121));
  }

  @Test
  void testNegativeNumber() {
    assertFalse(NumberPalindrome.isPalindrome(-121));
  }

  @Test
  void testSingleDigit() {
    assertTrue(NumberPalindrome.isPalindrome(0));
    assertTrue(NumberPalindrome.isPalindrome(5));
  }

  @Test
  void testNotPalindrome() {
    assertFalse(NumberPalindrome.isPalindrome(10));
    assertFalse(NumberPalindrome.isPalindrome(123));
  }

  @Test
  void testLargePalindrome() {
    assertTrue(NumberPalindrome.isPalindrome(12321));
    assertTrue(NumberPalindrome.isPalindrome(123321));
  }

  @Test
  void testEndsWithZero() {
    assertFalse(NumberPalindrome.isPalindrome(100));
  }
}
