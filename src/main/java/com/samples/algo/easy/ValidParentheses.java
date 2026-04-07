package com.samples.algo.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/*

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

 */

public class ValidParentheses {

  public static boolean isValidParentheses(String s) {
    Deque<Character> stack = new ArrayDeque<>();

    for (char ch : s.toCharArray()) {
      if ('(' == ch || '[' == ch || '{' == ch) {
        stack.push(ch);
      } else if (')' == ch || ']' == ch || '}' == ch) {
        if (stack.isEmpty()) {
          return false;
        }

        char paren = stack.pop();

        if ('(' == paren && ')' != ch) {
          return false;
        }

        if ('[' == paren && ']' != ch) {
          return false;
        }

        if ('{' == paren && '}' != ch) {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }
}
