package com.samples.datastruct.simple;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

class ArrayStackResizeTest {

  @Test
  void shouldResizeArrayOnPushBeyondCapacity() throws Exception {
    ArrayStack<Integer> stack = new ArrayStack<>();
    int initialCapacity = getCapacity(stack);

    assertThat(initialCapacity).isEqualTo(1);

    // Push 1 item — fills slot 0, capacity stays 1
    stack.push(1);
    assertThat(getCapacity(stack)).isEqualTo(1);

    // Push 2nd item — array full (n==1), resize 1 → 2
    stack.push(2);
    assertThat(getCapacity(stack)).isEqualTo(2);

    // Push 3rd item — array full (n==2), resize 2 → 4
    stack.push(3);
    assertThat(getCapacity(stack)).isEqualTo(4);

    // Push 5th item — array full (n==4), resize 4 → 8
    stack.push(4);
    stack.push(5);
    assertThat(getCapacity(stack)).isEqualTo(8);

    // All items still accessible in LIFO order
    assertThat(stack.pop()).isEqualTo(5);
    assertThat(stack.pop()).isEqualTo(4);
    assertThat(stack.pop()).isEqualTo(3);
    assertThat(stack.pop()).isEqualTo(2);
    assertThat(stack.pop()).isEqualTo(1);
  }

  @Test
  void shouldShrinkArrayWhenQuarterFull() throws Exception {
    ArrayStack<Integer> stack = new ArrayStack<>();

    // Push 8 items to grow capacity to 8
    for (int i = 1; i <= 8; i++) {
      stack.push(i);
    }
    assertThat(getCapacity(stack)).isEqualTo(8);

    // Pop until n < capacity / 4 (i.e. n < 2, so pop 7 times)
    for (int i = 0; i < 7; i++) {
      stack.pop();
    }
    // n == 1, capacity was 8 → shrinks to 4
    assertThat(getCapacity(stack)).isEqualTo(4);
    assertThat(stack.size()).isEqualTo(1);
  }

  @Test
  void shouldShrinkMultipleTimes() throws Exception {
    ArrayStack<Integer> stack = new ArrayStack<>();

    // Push 32 items to grow capacity to 32
    for (int i = 1; i <= 32; i++) {
      stack.push(i);
    }
    assertThat(getCapacity(stack)).isEqualTo(32);

    // Pop until n < 8 → shrinks to 16
    while (stack.size() > 7) {
      stack.pop();
    }
    assertThat(getCapacity(stack)).isEqualTo(16);

    // Pop until n < 4 → shrinks to 8
    while (stack.size() > 3) {
      stack.pop();
    }
    assertThat(getCapacity(stack)).isEqualTo(8);
  }

  @Test
  void shouldGrowAgainAfterShrink() throws Exception {
    ArrayStack<Integer> stack = new ArrayStack<>();

    // Fill and shrink
    for (int i = 1; i <= 8; i++) {
      stack.push(i);
    }
    while (stack.size() > 1) {
      stack.pop();
    }
    assertThat(getCapacity(stack)).isEqualTo(4);

    // Push again — should grow after filling capacity
    stack.push(100);
    stack.push(101);
    stack.push(102);
    assertThat(getCapacity(stack)).isEqualTo(4);

    // Push 4th new item — n becomes 4 == cap, triggers resize 4 → 8
    stack.push(103);
    assertThat(getCapacity(stack)).isEqualTo(8);
  }

  @Test
  void shouldMaintainCorrectLifoOrderAcrossResizes() throws Exception {
    ArrayStack<Integer> stack = new ArrayStack<>();

    // Push enough items to trigger multiple resizes
    for (int i = 1; i <= 20; i++) {
      stack.push(i);
    }

    // Pop and verify LIFO order
    for (int i = 20; i >= 1; i--) {
      assertThat(stack.pop()).isEqualTo(i);
    }
  }

  private int getCapacity(ArrayStack<?> stack) throws Exception {
    Field field = ArrayStack.class.getDeclaredField("array");
    field.setAccessible(true);
    Object[] array = (Object[]) field.get(stack);

    return array.length;
  }
}
