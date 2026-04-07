package com.samples.datastruct.simple;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StackTest {

  static Stream<Stack<Integer>> stackProvider() {
    return Stream.of(new ArrayStack<>(), new LinkedListStack<>());
  }

  @ParameterizedTest
  @MethodSource("stackProvider")
  void shouldCreateEmptyStack(Stack<Integer> stack) {
    assertThat(stack.isEmpty()).isTrue();
    assertThat(stack.size()).isZero();
  }

  @ParameterizedTest
  @MethodSource("stackProvider")
  void shouldPushSingleItem(Stack<Integer> stack) {
    stack.push(1);

    assertThat(stack.isEmpty()).isFalse();
    assertThat(stack.size()).isEqualTo(1);
  }

  @ParameterizedTest
  @MethodSource("stackProvider")
  void shouldPushMultipleItems(Stack<Integer> stack) {
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);

    assertThat(stack.size()).isEqualTo(5);
    assertThat(stack.isEmpty()).isFalse();
  }

  @ParameterizedTest
  @MethodSource("stackProvider")
  void shouldPopItem(Stack<Integer> stack) {
    stack.push(42);

    Integer item = stack.pop();

    assertThat(item).isEqualTo(42);
    assertThat(stack.isEmpty()).isTrue();
  }

  @ParameterizedTest
  @MethodSource("stackProvider")
  void shouldPopItemsInLifoOrder(Stack<Integer> stack) {
    stack.push(1);
    stack.push(2);
    stack.push(3);

    assertThat(stack.pop()).isEqualTo(3);
    assertThat(stack.pop()).isEqualTo(2);
    assertThat(stack.pop()).isEqualTo(1);
  }

  @ParameterizedTest
  @MethodSource("stackProvider")
  void shouldPopItemsInReversePushOrder(Stack<Integer> stack) {
    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.push(40);
    stack.push(50);

    assertThat(stack.pop()).isEqualTo(50);
    assertThat(stack.pop()).isEqualTo(40);
    assertThat(stack.pop()).isEqualTo(30);
    assertThat(stack.pop()).isEqualTo(20);
    assertThat(stack.pop()).isEqualTo(10);
  }

  @ParameterizedTest
  @MethodSource("stackProvider")
  void shouldPopFromEmptyStack(Stack<Integer> stack) {
    assertThatThrownBy(stack::pop)
      .isInstanceOf(RuntimeException.class)
      .hasMessageContaining("empty");
  }

  @ParameterizedTest
  @MethodSource("stackProvider")
  void shouldPushAfterPop(Stack<Integer> stack) {
    stack.push(1);
    stack.push(2);
    stack.pop();
    stack.push(3);

    assertThat(stack.pop()).isEqualTo(3);
    assertThat(stack.pop()).isEqualTo(1);
  }

  @ParameterizedTest
  @MethodSource("stackProvider")
  void shouldIsEmptyTrueOnEmptyStack(Stack<Integer> stack) {
    assertThat(stack.isEmpty()).isTrue();
  }

  @ParameterizedTest
  @MethodSource("stackProvider")
  void shouldIsEmptyFalseOnNonEmptyStack(Stack<Integer> stack) {
    stack.push(1);

    assertThat(stack.isEmpty()).isFalse();
  }

  @ParameterizedTest
  @MethodSource("stackProvider")
  void shouldIsEmptyTrueAfterPoppingAllItems(Stack<Integer> stack) {
    stack.push(1);
    stack.push(2);
    stack.pop();
    stack.pop();

    assertThat(stack.isEmpty()).isTrue();
  }

  @ParameterizedTest
  @MethodSource("stackProvider")
  void shouldReturnCorrectSize(Stack<Integer> stack) {
    assertThat(stack.size()).isZero();

    stack.push(1);
    assertThat(stack.size()).isEqualTo(1);

    stack.push(2);
    assertThat(stack.size()).isEqualTo(2);

    stack.pop();
    assertThat(stack.size()).isEqualTo(1);
  }

  @ParameterizedTest
  @MethodSource("stackProvider")
  void shouldSizeDecreaseOnPop(Stack<Integer> stack) {
    stack.push(1);
    stack.push(2);
    stack.push(3);

    stack.pop();
    assertThat(stack.size()).isEqualTo(2);

    stack.pop();
    assertThat(stack.size()).isEqualTo(1);

    stack.pop();
    assertThat(stack.size()).isZero();
  }

  @ParameterizedTest
  @MethodSource("stackProvider")
  void shouldHandleNullValues(Stack<Integer> stack) {
    stack.push(null);

    assertThat(stack.size()).isEqualTo(1);
    assertThat(stack.isEmpty()).isFalse();
    assertThat(stack.pop()).isNull();
  }

  @ParameterizedTest
  @MethodSource("stackProvider")
  void shouldHandleNegativeValues(Stack<Integer> stack) {
    stack.push(-1);
    stack.push(-2);
    stack.push(-3);

    assertThat(stack.pop()).isEqualTo(-3);
    assertThat(stack.pop()).isEqualTo(-2);
    assertThat(stack.pop()).isEqualTo(-1);
  }

  @ParameterizedTest
  @MethodSource("stackProvider")
  void shouldHandleZero(Stack<Integer> stack) {
    stack.push(0);
    stack.push(0);
    stack.push(0);

    assertThat(stack.size()).isEqualTo(3);
    assertThat(stack.pop()).isZero();
    assertThat(stack.pop()).isZero();
    assertThat(stack.pop()).isZero();
  }

  @ParameterizedTest
  @MethodSource("stackProvider")
  void shouldHandleLargeValues(Stack<Integer> stack) {
    stack.push(Integer.MAX_VALUE);
    stack.push(Integer.MIN_VALUE);

    assertThat(stack.pop()).isEqualTo(Integer.MIN_VALUE);
    assertThat(stack.pop()).isEqualTo(Integer.MAX_VALUE);
  }

  @ParameterizedTest
  @MethodSource("stackProvider")
  void shouldPopUntilEmpty(Stack<Integer> stack) {
    stack.push(1);
    stack.push(2);
    stack.push(3);

    stack.pop();
    stack.pop();
    stack.pop();

    assertThat(stack.isEmpty()).isTrue();
    assertThat(stack.size()).isZero();
  }

  @ParameterizedTest
  @MethodSource("stackProvider")
  void shouldInterleavePushAndPop(Stack<Integer> stack) {
    stack.push(1);
    stack.push(2);
    assertThat(stack.pop()).isEqualTo(2);

    stack.push(3);
    stack.push(4);
    assertThat(stack.pop()).isEqualTo(4);
    assertThat(stack.pop()).isEqualTo(3);

    stack.push(5);
    assertThat(stack.pop()).isEqualTo(5);
    assertThat(stack.pop()).isEqualTo(1);
  }

  @ParameterizedTest
  @MethodSource("stackProvider")
  void shouldConsecutivePops(Stack<Integer> stack) {
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);

    assertThat(stack.pop()).isEqualTo(5);
    assertThat(stack.pop()).isEqualTo(4);
    assertThat(stack.pop()).isEqualTo(3);
    assertThat(stack.pop()).isEqualTo(2);
    assertThat(stack.pop()).isEqualTo(1);

    assertThat(stack.isEmpty()).isTrue();
  }

  @ParameterizedTest
  @MethodSource("stackProvider")
  void shouldMultipleEmptyChecks(Stack<Integer> stack) {
    assertThat(stack.isEmpty()).isTrue();

    stack.push(1);
    assertThat(stack.isEmpty()).isFalse();
    assertThat(stack.isEmpty()).isFalse();

    stack.pop();
    assertThat(stack.isEmpty()).isTrue();
  }

  @ParameterizedTest
  @MethodSource("stackProvider")
  void shouldSizeAfterMultipleOperations(Stack<Integer> stack) {
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.pop();
    stack.push(4);
    stack.pop();
    stack.pop();
    stack.push(5);
    stack.push(6);

    assertThat(stack.size()).isEqualTo(3);
    assertThat(stack.pop()).isEqualTo(6);
    assertThat(stack.pop()).isEqualTo(5);
  }
}
