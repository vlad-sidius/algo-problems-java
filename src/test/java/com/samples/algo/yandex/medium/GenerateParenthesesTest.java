package com.samples.algo.yandex.medium;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("LeetCode 22: Generate Parentheses")
public class GenerateParenthesesTest {

  private final GenerateParentheses instance = new GenerateParentheses();

  static Stream<Arguments> provideCases() {
    return Stream.of(
        Arguments.of(1, Set.of("()")),
        Arguments.of(2, Set.of("(())", "()()")),
        Arguments.of(3, Set.of("((()))", "(()())", "(())()", "()(())", "()()()")),
        Arguments.of(4, Set.of("(((())))", "((()()))", "((())())", "((()))()", "(()(()))",
            "(()()())", "(()())()", "(())(())", "(())()()", "()((()))",
            "()(()())", "()(())()", "()()(())", "()()()()"))
    );
  }

  @ParameterizedTest(name = "n={0} → expected size & content match")
  @MethodSource("provideCases")
  void testGenerateParenthesis(int n, Set<String> expected) {
    List<String> result = instance.generateParenthesis(n);

    // Order doesn't matter; verify exact set membership
    assertEquals(expected.size(), result.size(), String.format("Expected %d combinations for n=%d", expected.size(), n));
    assertTrue(expected.containsAll(result), "Generated set should match expected");
  }
}
