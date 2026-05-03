package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("LeetCode 232: Queue using Stacks")
public class QueueUsingStacksTest {

  private final QueueUsingStacks instance = new QueueUsingStacks();
  
  @Test
  @DisplayName("Basic FIFO order")
  void testBasicFIFO() {
    instance.push(1);
    instance.push(2);
    instance.push(3);

    assertEquals(1, instance.peek());
    assertEquals(1, instance.pop());
    assertEquals(2, instance.peek());
    assertEquals(2, instance.pop());
    assertEquals(3, instance.pop());
    assertTrue(instance.empty());
  }

  @Test
  @DisplayName("Interleaved push/pop/peek")
  void testInterleaved() {
    instance.push(10);
    instance.push(20);
    assertEquals(10, instance.pop());
    instance.push(30);
    assertEquals(20, instance.peek());
    assertEquals(20, instance.pop());
    assertEquals(30, instance.pop());
    assertTrue(instance.empty());
  }

  @Test
  @DisplayName("Empty queue throws on pop/peek")
  void testEmptyOperations() {
    assertThrows(NoSuchElementException.class, instance::pop);
    assertThrows(NoSuchElementException.class, instance::peek);
  }

  @Test
  @DisplayName("State preservation after multiple peeks")
  void testPeekIdempotent() {
    instance.push(5);
    assertEquals(5, instance.peek());
    assertEquals(5, instance.peek()); // Should not consume element
    assertEquals(5, instance.peek());
    assertFalse(instance.empty());
  }
}
