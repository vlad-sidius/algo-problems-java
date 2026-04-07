package com.samples.algo.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidParenthesesTest {

  @Test
  void testSimpleValid() {
    assertTrue(ValidParentheses.isValidParentheses("()"));
    assertTrue(ValidParentheses.isValidParentheses("[]"));
    assertTrue(ValidParentheses.isValidParentheses("{}"));
  }

  @Test
  void testSimpleInvalid() {
    assertFalse(ValidParentheses.isValidParentheses("("));
    assertFalse(ValidParentheses.isValidParentheses(")"));
    assertFalse(ValidParentheses.isValidParentheses("]"));
  }

  @Test
  void testNestedValid() {
    assertTrue(ValidParentheses.isValidParentheses("()[]{}"));
    assertTrue(ValidParentheses.isValidParentheses("{[]}"));
    assertTrue(ValidParentheses.isValidParentheses("([])"));
  }

  @Test
  void testNestedInvalid() {
    assertFalse(ValidParentheses.isValidParentheses("(]"));
    assertFalse(ValidParentheses.isValidParentheses("([)]"));
    assertFalse(ValidParentheses.isValidParentheses("{[}]"));
  }

  @Test
  void testDeeplyNested() {
    assertTrue(ValidParentheses.isValidParentheses("((()))"));
    assertTrue(ValidParentheses.isValidParentheses("{{{}}}"));
    assertTrue(ValidParentheses.isValidParentheses("[[[]]]"));
  }

  @Test
  void testEmptyString() {
    assertTrue(ValidParentheses.isValidParentheses(""));
  }

  @Test
  void testComplexValid() {
    assertTrue(ValidParentheses.isValidParentheses("()[]{}()[]{}"));
    assertTrue(ValidParentheses.isValidParentheses("{[()]}"));
  }

  @Test
  void testComplexInvalid() {
    assertFalse(ValidParentheses.isValidParentheses("())"));
    assertFalse(ValidParentheses.isValidParentheses("(()"));
    assertFalse(ValidParentheses.isValidParentheses("}{"));
  }
}
