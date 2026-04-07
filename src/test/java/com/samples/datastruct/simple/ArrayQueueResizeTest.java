package com.samples.datastruct.simple;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArrayQueueResizeTest {

  private ArrayQueue<Integer> queue;

  @BeforeEach
  void setUp() {
    queue = new ArrayQueue<>();
  }

  @Test
  void shouldResizeUpWhenFull() {
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);

    assertThat(queue.size()).isEqualTo(5);

    queue.enqueue(6);

    assertThat(queue.size()).isEqualTo(6);
    assertThat(queue.dequeue()).isEqualTo(1);
    assertThat(queue.dequeue()).isEqualTo(2);
    assertThat(queue.dequeue()).isEqualTo(3);
    assertThat(queue.dequeue()).isEqualTo(4);
    assertThat(queue.dequeue()).isEqualTo(5);
    assertThat(queue.dequeue()).isEqualTo(6);
  }

  @Test
  void shouldResizeDownWhenQuarterFull() {
    for (int i = 0; i < 20; i++) {
      queue.enqueue(i);
    }

    assertThat(queue.size()).isEqualTo(20);

    for (int i = 0; i < 16; i++) {
      queue.dequeue();
    }

    assertThat(queue.size()).isEqualTo(4);

    for (int i = 0; i < 4; i++) {
      assertThat(queue.dequeue()).isEqualTo(16 + i);
    }

    assertThat(queue.isEmpty()).isTrue();
  }

  @Test
  void shouldMaintainFIFOOrderAfterMultipleResizes() {
    for (int i = 0; i < 100; i++) {
      queue.enqueue(i);
    }

    for (int i = 0; i < 50; i++) {
      assertThat(queue.dequeue()).isEqualTo(i);
    }

    for (int i = 100; i < 150; i++) {
      queue.enqueue(i);
    }

    for (int i = 50; i < 150; i++) {
      assertThat(queue.dequeue()).isEqualTo(i);
    }

    assertThat(queue.isEmpty()).isTrue();
  }

  @Test
  void shouldHandleResizeWithNullValues() {
    for (int i = 0; i < 6; i++) {
      queue.enqueue(null);
    }

    assertThat(queue.size()).isEqualTo(6);

    for (int i = 0; i < 6; i++) {
      assertThat(queue.dequeue()).isNull();
    }
  }

  @Test
  void shouldResizeAlternatingUpAndDown() {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 20; j++) {
        queue.enqueue(j);
      }
      for (int j = 0; j < 20; j++) {
        queue.dequeue();
      }
    }

    assertThat(queue.isEmpty()).isTrue();
  }

  @Test
  void shouldPreserveWrappingOrderAfterResize() {
    for (int i = 0; i < 5; i++) {
      queue.enqueue(i);
    }

    for (int i = 0; i < 3; i++) {
      queue.dequeue();
    }

    for (int i = 5; i < 10; i++) {
      queue.enqueue(i);
    }

    assertThat(queue.size()).isEqualTo(7);
    assertThat(queue.dequeue()).isEqualTo(3);
    assertThat(queue.dequeue()).isEqualTo(4);
    assertThat(queue.dequeue()).isEqualTo(5);
    assertThat(queue.dequeue()).isEqualTo(6);
    assertThat(queue.dequeue()).isEqualTo(7);
    assertThat(queue.dequeue()).isEqualTo(8);
    assertThat(queue.dequeue()).isEqualTo(9);
  }


}
