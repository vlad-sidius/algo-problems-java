package com.samples.algo.yandex.medium;

import java.util.ArrayList;
import java.util.List;

/*

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Constraints:

1 <= n <= 8

 */

public class GenerateParentheses {

  public List<String> generateParenthesis(int n) {
    if (n == 1) {
      return List.of("()");
    }

    List<String> result = new ArrayList<>();
    StringBuilder acc = new StringBuilder(n * 2);

    loop(result, acc, 0, 0, n);

    return result;
  }

  private void loop(List<String> result, StringBuilder acc, int openCount, int closeCount, int limit) {
    if (openCount == limit && closeCount == limit) {
      result.add(acc.toString());
      return;
    }

    if (openCount < limit) {
      acc.append("(");
      loop(result, acc, openCount + 1, closeCount, limit);
      acc.deleteCharAt(acc.length() - 1);
    }

    if (closeCount < openCount) {
      acc.append(")");
      loop(result, acc, openCount, closeCount + 1, limit);
      acc.deleteCharAt(acc.length() - 1);
    }
  }
}
