package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("205. Isomorphic Strings")
public class IsomorphicStringsTest {

  private final IsomorphicStrings instance = new IsomorphicStrings();

  static Stream<Arguments> provideCases() {
    return Stream.of(
        Arguments.of("egg", "add", true),
        Arguments.of("foo", "bar", false),
        Arguments.of("paper", "title", true),
        Arguments.of("ab", "aa", false),       // Bijection failure
        Arguments.of("aa", "ab", false),       // Reverse bijection failure
        Arguments.of("abc", "def", true),      // All unique chars
        Arguments.of("a", "a", true),          // Single char
        Arguments.of("badc", "baba", false),   // Pattern mismatch
        Arguments.of("123456", "654321", true) // Numeric strings
    );
  }

  @ParameterizedTest(name = "s='{0}', t='{1}' → expected={2}")
  @MethodSource("provideCases")
  void testIsIsomorphic(String s, String t, boolean expected) {
    assertEquals(expected, instance.isIsomorphic(s, t));
  }
}
