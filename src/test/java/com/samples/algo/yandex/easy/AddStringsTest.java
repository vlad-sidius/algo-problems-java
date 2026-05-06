package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("415. Add Strings")
public class AddStringsTest {

  private final AddStrings instance = new AddStrings();

  static Stream<Arguments> provideCases() {
    return Stream.of(
        Arguments.of("11", "123", "134"),
        Arguments.of("456", "77", "533"),
        Arguments.of("0", "0", "0"),
        Arguments.of("1", "9", "10"),
        Arguments.of("999", "1", "1000"),
        Arguments.of("123456789", "987654321", "1111111110"),
        Arguments.of("9", "99", "108"),
        Arguments.of("0", "123", "123"),
        Arguments.of("99999999999999999999", "1", "100000000000000000000") // 20-digit carry propagation
    );
  }

  @ParameterizedTest(name = "num1={0}, num2={1} → expected={2}")
  @MethodSource("provideCases")
  void testAddStrings(String num1, String num2, String expected) {
    assertEquals(expected, instance.addStrings(num1, num2));
  }
}
