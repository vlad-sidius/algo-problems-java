package com.samples.datastruct.simple;

public class LinkedListQueue<T> implements Queue<T> {

  private int n = 0;
  private Node<T> first = null;
  private Node<T> last = null;

  @Override
  public void enqueue(final T item) {
    var oldLast = last;
    last = new Node<>(item);

    if (isEmpty()) {
      first = last;
    } else {
      oldLast.setNext(last);
    }

    n++;
  }

  @Override
  public T dequeue() {
    if (isEmpty()) {
      throw new RuntimeException("Queue is empty");
    }

    var oldFirst = first;
    first = first.getNext();
    oldFirst.setNext(null);
    n--;

    return oldFirst.getItem();
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
