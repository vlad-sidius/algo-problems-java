package com.samples.algo.yandex.medium;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 567: Permutation in String")
public class PermutationInStringTest {

  private final PermutationInString instance = new PermutationInString();

  static Stream<Arguments> provideCases() {
    return Stream.of(
        Arguments.of("ab", "eidbaooo", true),      // LC Example 1
        Arguments.of("ab", "eidboaoo", false),     // LC Example 2
        Arguments.of("abc", "bbbca", true),        // Permutation at end
        Arguments.of("abc", "ccccbbbbaaaa", false),// No permutation
        Arguments.of("a", "ab", true),             // Single char
        Arguments.of("adc", "dcda", true),         // Full match
        Arguments.of("hello", "ooolleoooleh", false), // Length mismatch in content
        Arguments.of("abc", "ccccbbbbaaa", false), // Close but wrong counts
        Arguments.of("", "a", true),               // Edge: empty s1
        Arguments.of("a", "", false)               // Edge: empty s2
    );
  }

  @ParameterizedTest(name = "s1={0}, s2={1} → expected={2}")
  @MethodSource("provideCases")
  void testCheckInclusion(String s1, String s2, boolean expected) {
    assertEquals(expected, instance.checkInclusion(s1, s2));
  }
}
