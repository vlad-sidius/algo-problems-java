package com.samples.algo.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ReversePolishNotationEvalTest {

  private final ReversePolishNotationEval instance = new ReversePolishNotationEval();

  @Test
  void testEvaluate1() {
    String[] input = new String[] { "2","1","+","3","*" };
    int expected = 9;
    int actual = instance.evalRPN(input);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testEvaluate2() {
    String[] input = new String[] { "4","13","5","/","+" };
    int expected = 6;
    int actual = instance.evalRPN(input);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testEvaluate3() {
    String[] input = new String[] { "10","6","9","3","+","-11","*","/","*","17","+","5","+" };
    int expected = 22;
    int actual = instance.evalRPN(input);

    assertThat(actual).isEqualTo(expected);
  }
}
