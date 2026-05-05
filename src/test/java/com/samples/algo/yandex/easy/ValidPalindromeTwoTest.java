package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("680. Valid Palindrome II")
public class ValidPalindromeTwoTest {

  private final ValidPalindromeTwo instance = new ValidPalindromeTwo();

  @ParameterizedTest(name = "s='{0}' → expected={1}")
  @MethodSource("provideCases")
  void testValidPalindrome(String s, boolean expected) {
    assertEquals(expected, instance.validPalindrome(s));
  }

  static Stream<Arguments> provideCases() {
    return Stream.of(
        Arguments.of("aba", true),          // Already palindrome
        Arguments.of("abca", true),         // Delete 'c' → "aba"
        Arguments.of("abc", false),         // Needs >1 deletion
        Arguments.of("deeee", true),        // Delete 'd' or last 'e'
        Arguments.of("eedede", true),       // Delete middle 'd' → "eeee"
        Arguments.of("a", true),            // Single char
        Arguments.of("ab", true),           // Delete either → palindrome
        Arguments.of("abcdeffedcb", true),  // Symmetric, valid
        Arguments.of("abcdeffedcba", true), // Full palindrome
        Arguments.of("cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuc", true) // LC edge case
    );
  }

  //
}
