package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 1496: Path Crossing (No Bit Packing)")
public class PathCrossingTest {

  private final PathCrossing instance = new PathCrossing();

  static Stream<Arguments> provideCases() {
    return Stream.of(
        Arguments.of("NES", false),
        Arguments.of("NESW", true),
        Arguments.of("NS", true),
        Arguments.of("N", false),
        Arguments.of("WNNSNW", true),
        Arguments.of("EENNWW", false)
    );
  }

  @ParameterizedTest(name = "path={0} → expected={1}")
  @MethodSource("provideCases")
  void testIsPathCrossing(String path, boolean expected) {
    assertEquals(expected, instance.isPathCrossing(path));
  }
}
