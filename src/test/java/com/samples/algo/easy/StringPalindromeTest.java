package com.samples.algo.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringPalindromeTest {

  @Test
  void testSimplePalindrome() {
    assertTrue(StringPalindrome.isPalindrome("racecar"));
  }

  @Test
  void testSimpleNotPalindrome() {
    assertFalse(StringPalindrome.isPalindrome("hello"));
  }

  @Test
  void testSingleCharacter() {
    assertTrue(StringPalindrome.isPalindrome("a"));
  }

  @Test
  void testEmptyString() {
    assertTrue(StringPalindrome.isPalindrome(""));
  }

  @Test
  void testTwoCharactersSame() {
    assertTrue(StringPalindrome.isPalindrome("aa"));
  }

  @Test
  void testTwoCharactersDifferent() {
    assertFalse(StringPalindrome.isPalindrome("ab"));
  }

  @Test
  void testLongerPalindrome() {
    assertTrue(StringPalindrome.isPalindrome("madam"));
    assertTrue(StringPalindrome.isPalindrome("noon"));
  }

  @Test
  void testMixedCase() {
    assertTrue(StringPalindrome.isPalindrome("Racecar"));
  }

  @Test
  void testWithSpaces() {
    assertTrue(StringPalindrome.isPalindrome("race car"));
  }

  @Test
  void testWithSpecialCharacters() {
    assertTrue(StringPalindrome.isPalindrome("race!car"));
  }
}
