package com.samples.algo.medium;

/*

You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.

 */

import java.util.ArrayDeque;
import java.util.Deque;

public class ReversePolishNotationEval {

  public int evalRPN(String[] tokens) {
    Deque<Integer> stack = new ArrayDeque<>();

    for (String token : tokens) {
      switch (token) {
        case "+" -> {
          int op1 = stack.pop();
          int op2 = stack.pop();
          stack.push(op1 + op2);
        }
        case "-" -> {
          int op1 = stack.pop();
          int op2 = stack.pop();
          stack.push(op2 - op1);
        }
        case "*" -> {
          int op1 = stack.pop();
          int op2 = stack.pop();
          stack.push(op1 * op2);
        }
        case "/" -> {
          int op1 = stack.pop();
          int op2 = stack.pop();
          stack.push(op2 / op1);
        }
        default -> {
          Integer num = Integer.parseInt(token);
          stack.push(num);
        }
      }
    }

    return stack.pop();
  }
}
