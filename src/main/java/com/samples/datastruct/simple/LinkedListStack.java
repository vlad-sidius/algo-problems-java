package com.samples.datastruct.simple;

public class LinkedListStack<T> implements Stack<T> {

  private Node<T> head = null;
  private int n = 0;

  @Override
  public void push(final T item) {
    Node<T> oldHead = head;
    head = new Node<>(item, oldHead);
    n++;
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      throw new RuntimeException("Stack is empty");
    }

    T item = head.getItem();
    Node<T> oldHead = head;
    head = head.getNext();
    oldHead.setNext(null);
    n--;

    return item;
  }

  @Override
  public boolean isEmpty() {
    return n == 0;
  }

  @Override
  public int size() {
    return n;
  }
}
