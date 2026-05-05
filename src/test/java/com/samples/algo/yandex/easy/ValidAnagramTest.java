package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ValidAnagramTest {

  private final ValidAnagram instance = new ValidAnagram();

  static Stream<Arguments> provideCoreCases() {
    return Stream.of(
        Arguments.of("anagram", "nagaram", true),
        Arguments.of("rat", "car", false),
        Arguments.of("a", "ab", false),
        Arguments.of("", "", true),
        Arguments.of("aabbcc", "abcabc", true),
        Arguments.of("abc", "def", false),
        Arguments.of("zzz", "zzz", true)
    );
  }

  @ParameterizedTest(name = "s='{0}', t='{1}' → expected={2}")
  @MethodSource("provideCoreCases")
  void testIsAnagram(String s, String t, boolean expected) {
    assertEquals(expected, instance.isAnagram(s, t));
  }

  @Test
  @DisplayName("Large identical strings (performance baseline)")
  void testLargeStrings() {
    String s = "a".repeat(50000);
    String t = "a".repeat(50000);
    assertTrue(instance.isAnagram(s, t));
  }
}
