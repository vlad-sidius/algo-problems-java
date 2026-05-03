package com.samples.algo.yandex.easy;

/*

Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the
functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

- void push(int x) Pushes element x to the back of the queue.
- int pop() Removes the element from the front of the queue and returns it.
- int peek() Returns the element at the front of the queue.
- boolean empty() Returns true if the queue is empty, false otherwise.

Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size,
and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list
or deque (double-ended queue) as long as you use only a stack's standard operations.


 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class QueueUsingStacks {

  private Deque<Integer> inStack;
  private Deque<Integer> outStack;

  public QueueUsingStacks() {
    inStack = new ArrayDeque<>();
    outStack = new ArrayDeque<>();
  }

  public void push(int x) {
    inStack.push(x);
  }

  public int pop() {
    if (empty()) throw new NoSuchElementException("Queue is empty");
    peek();
    return outStack.pop();
  }

  public int peek() {
    if (empty()) throw new NoSuchElementException("Queue is empty");

    if (outStack.isEmpty()) {
      while (!inStack.isEmpty()) {
        outStack.push(inStack.pop());
      }
    }

    return outStack.peek();
  }

  public boolean empty() {
    return inStack.isEmpty() && outStack.isEmpty();
  }
}
