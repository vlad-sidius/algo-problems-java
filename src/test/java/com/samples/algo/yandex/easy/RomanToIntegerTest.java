package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("13. Roman to Integer")
public class RomanToIntegerTest {

  private final RomanToInteger instance = new RomanToInteger();

  static Stream<Arguments> provideCases() {
    return Stream.of(
        Arguments.of("III", 3),
        Arguments.of("LVIII", 58),
        Arguments.of("MCMXCIV", 1994),
        Arguments.of("IV", 4),
        Arguments.of("IX", 9),
        Arguments.of("XL", 40),
        Arguments.of("XC", 90),
        Arguments.of("CD", 400),
        Arguments.of("CM", 900),
        Arguments.of("I", 1),
        Arguments.of("MMMCMXCIX", 3999), // Max valid Roman numeral
        Arguments.of("MM", 2000)
    );
  }

  @ParameterizedTest(name = "roman={0} → expected={1}")
  @MethodSource("provideCases")
  void testRomanToInt(String roman, int expected) {
    int actual = instance.romanToInt(roman);
    assertEquals(expected, actual);
  }
}
