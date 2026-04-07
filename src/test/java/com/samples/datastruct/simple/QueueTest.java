package com.samples.datastruct.simple;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class QueueTest {

  static Stream<Queue<Integer>> queueProvider() {
    return Stream.of(new ArrayQueue<>(), new LinkedListQueue<>());
  }

  @ParameterizedTest
  @MethodSource("queueProvider")
  void shouldCreateEmptyQueue(Queue<Integer> queue) {
    assertThat(queue.isEmpty()).isTrue();
    assertThat(queue.size()).isZero();
  }

  @ParameterizedTest
  @MethodSource("queueProvider")
  void shouldEnqueueSingleItem(Queue<Integer> queue) {
    queue.enqueue(1);

    assertThat(queue.isEmpty()).isFalse();
    assertThat(queue.size()).isEqualTo(1);
  }

  @ParameterizedTest
  @MethodSource("queueProvider")
  void shouldEnqueueMultipleItems(Queue<Integer> queue) {
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);

    assertThat(queue.size()).isEqualTo(5);
    assertThat(queue.isEmpty()).isFalse();
  }

  @ParameterizedTest
  @MethodSource("queueProvider")
  void shouldDequeueItem(Queue<Integer> queue) {
    queue.enqueue(42);

    Integer item = queue.dequeue();

    assertThat(item).isEqualTo(42);
    assertThat(queue.isEmpty()).isTrue();
  }

  @ParameterizedTest
  @MethodSource("queueProvider")
  void shouldDequeueItemsInFIFOOrder(Queue<Integer> queue) {
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);

    assertThat(queue.dequeue()).isEqualTo(1);
    assertThat(queue.dequeue()).isEqualTo(2);
    assertThat(queue.dequeue()).isEqualTo(3);
  }

  @ParameterizedTest
  @MethodSource("queueProvider")
  void shouldDequeueItemsInSameOrderAsEnqueued(Queue<Integer> queue) {
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    queue.enqueue(40);
    queue.enqueue(50);

    assertThat(queue.dequeue()).isEqualTo(10);
    assertThat(queue.dequeue()).isEqualTo(20);
    assertThat(queue.dequeue()).isEqualTo(30);
    assertThat(queue.dequeue()).isEqualTo(40);
    assertThat(queue.dequeue()).isEqualTo(50);
  }

  @ParameterizedTest
  @MethodSource("queueProvider")
  void shouldDequeueFromEmptyQueue(Queue<Integer> queue) {
    assertThatThrownBy(queue::dequeue)
        .isInstanceOf(RuntimeException.class)
        .hasMessageContaining("empty");
  }

  @ParameterizedTest
  @MethodSource("queueProvider")
  void shouldEnqueueAfterDequeue(Queue<Integer> queue) {
    queue.enqueue(1);
    queue.enqueue(2);
    queue.dequeue();
    queue.enqueue(3);

    assertThat(queue.dequeue()).isEqualTo(2);
    assertThat(queue.dequeue()).isEqualTo(3);
  }

  @ParameterizedTest
  @MethodSource("queueProvider")
  void shouldIsEmptyTrueOnEmptyQueue(Queue<Integer> queue) {
    assertThat(queue.isEmpty()).isTrue();
  }

  @ParameterizedTest
  @MethodSource("queueProvider")
  void shouldIsEmptyFalseOnNonEmptyQueue(Queue<Integer> queue) {
    queue.enqueue(1);

    assertThat(queue.isEmpty()).isFalse();
  }

  @ParameterizedTest
  @MethodSource("queueProvider")
  void shouldIsEmptyTrueAfterDequeuingAllItems(Queue<Integer> queue) {
    queue.enqueue(1);
    queue.enqueue(2);
    queue.dequeue();
    queue.dequeue();

    assertThat(queue.isEmpty()).isTrue();
  }

  @ParameterizedTest
  @MethodSource("queueProvider")
  void shouldReturnCorrectSize(Queue<Integer> queue) {
    assertThat(queue.size()).isZero();

    queue.enqueue(1);
    assertThat(queue.size()).isEqualTo(1);

    queue.enqueue(2);
    assertThat(queue.size()).isEqualTo(2);

    queue.dequeue();
    assertThat(queue.size()).isEqualTo(1);
  }

  @ParameterizedTest
  @MethodSource("queueProvider")
  void shouldSizeDecreaseOnDequeue(Queue<Integer> queue) {
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);

    queue.dequeue();
    assertThat(queue.size()).isEqualTo(2);

    queue.dequeue();
    assertThat(queue.size()).isEqualTo(1);

    queue.dequeue();
    assertThat(queue.size()).isZero();
  }

  @ParameterizedTest
  @MethodSource("queueProvider")
  void shouldHandleNullValues(Queue<Integer> queue) {
    queue.enqueue(null);

    assertThat(queue.size()).isEqualTo(1);
    assertThat(queue.isEmpty()).isFalse();
    assertThat(queue.dequeue()).isNull();
  }

  @ParameterizedTest
  @MethodSource("queueProvider")
  void shouldHandleNegativeValues(Queue<Integer> queue) {
    queue.enqueue(-1);
    queue.enqueue(-2);
    queue.enqueue(-3);

    assertThat(queue.dequeue()).isEqualTo(-1);
    assertThat(queue.dequeue()).isEqualTo(-2);
    assertThat(queue.dequeue()).isEqualTo(-3);
  }

  @ParameterizedTest
  @MethodSource("queueProvider")
  void shouldHandleZero(Queue<Integer> queue) {
    queue.enqueue(0);
    queue.enqueue(0);
    queue.enqueue(0);

    assertThat(queue.size()).isEqualTo(3);
    assertThat(queue.dequeue()).isZero();
    assertThat(queue.dequeue()).isZero();
    assertThat(queue.dequeue()).isZero();
  }

  @ParameterizedTest
  @MethodSource("queueProvider")
  void shouldHandleLargeValues(Queue<Integer> queue) {
    queue.enqueue(Integer.MAX_VALUE);
    queue.enqueue(Integer.MIN_VALUE);

    assertThat(queue.dequeue()).isEqualTo(Integer.MAX_VALUE);
    assertThat(queue.dequeue()).isEqualTo(Integer.MIN_VALUE);
  }

  @ParameterizedTest
  @MethodSource("queueProvider")
  void shouldDequeueUntilEmpty(Queue<Integer> queue) {
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);

    queue.dequeue();
    queue.dequeue();
    queue.dequeue();

    assertThat(queue.isEmpty()).isTrue();
    assertThat(queue.size()).isZero();
  }

  @ParameterizedTest
  @MethodSource("queueProvider")
  void shouldInterleaveEnqueueAndDequeue(Queue<Integer> queue) {
    queue.enqueue(1);
    queue.enqueue(2);
    assertThat(queue.dequeue()).isEqualTo(1);

    queue.enqueue(3);
    queue.enqueue(4);
    assertThat(queue.dequeue()).isEqualTo(2);
    assertThat(queue.dequeue()).isEqualTo(3);

    queue.enqueue(5);
    assertThat(queue.dequeue()).isEqualTo(4);
    assertThat(queue.dequeue()).isEqualTo(5);
  }

  @ParameterizedTest
  @MethodSource("queueProvider")
  void shouldConsecutiveDequeues(Queue<Integer> queue) {
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);

    assertThat(queue.dequeue()).isEqualTo(1);
    assertThat(queue.dequeue()).isEqualTo(2);
    assertThat(queue.dequeue()).isEqualTo(3);
    assertThat(queue.dequeue()).isEqualTo(4);
    assertThat(queue.dequeue()).isEqualTo(5);

    assertThat(queue.isEmpty()).isTrue();
  }

  @ParameterizedTest
  @MethodSource("queueProvider")
  void shouldMultipleEmptyChecks(Queue<Integer> queue) {
    assertThat(queue.isEmpty()).isTrue();

    queue.enqueue(1);
    assertThat(queue.isEmpty()).isFalse();
    assertThat(queue.isEmpty()).isFalse();

    queue.dequeue();
    assertThat(queue.isEmpty()).isTrue();
  }

  @ParameterizedTest
  @MethodSource("queueProvider")
  void shouldSizeAfterMultipleOperations(Queue<Integer> queue) {
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.dequeue();
    queue.enqueue(4);
    queue.dequeue();
    queue.dequeue();
    queue.enqueue(5);
    queue.enqueue(6);

    assertThat(queue.size()).isEqualTo(3);
    assertThat(queue.dequeue()).isEqualTo(4);
    assertThat(queue.dequeue()).isEqualTo(5);
    assertThat(queue.dequeue()).isEqualTo(6);
  }
}
