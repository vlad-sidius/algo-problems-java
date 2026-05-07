package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@DisplayName("LeetCode 1656: Design an Ordered Stream")
public class OrderedStreamTest {

  static Stream<Arguments> provideStreamCases() {
    // [idKey, value] pairs. Expected output lists per insert call.
    return Stream.of(
        // Official Example
        Arguments.of(5, new int[][]{{4, 1}, {2, 2}, {1, 3}, {3, 4}, {5, 5}},
            List.of(List.of(), List.of(), List.of("3", "2"), List.of("4", "1"), List.of("5"))),
        // Out-of-order with large gap
        Arguments.of(4, new int[][]{{3, 3}, {1, 1}, {2, 2}, {4, 4}},
            List.of(List.of(), List.of("1"), List.of("2", "3"), List.of("4"))),
        // Perfect order
        Arguments.of(3, new int[][]{{1, 1}, {2, 2}, {3, 3}},
            List.of(List.of("1"), List.of("2"), List.of("3"))),
        // Reverse order (buffer fills, then flushes at end)
        Arguments.of(3, new int[][]{{3, 3}, {2, 2}, {1, 1}},
            List.of(List.of(), List.of(), List.of("1", "2", "3"))),
        // Single element
        Arguments.of(1, new int[][]{{1, 1}},
            List.of(List.of("1")))
    );
  }

  @ParameterizedTest(name = "n={0}, inserts={1}, expectedChunks={2}")
  @MethodSource("provideStreamCases")
  void testOrderedStream(int n, int[][] inserts, List<List<String>> expectedChunks) {
    OrderedStream os = new OrderedStream(n);

    for (int i = 0; i < inserts.length; i++) {
      List<String> chunk = os.insert(inserts[i][0], String.valueOf(inserts[i][1]));
      assertIterableEquals(expectedChunks.get(i), chunk, String.format("Mismatch at insert #%d", i + 1));
    }
  }
}
