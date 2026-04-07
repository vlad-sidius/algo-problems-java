package com.samples.datastruct.simple;

public class ArrayQueue<T> implements Queue<T> {

  private T[] array;
  private int len;
  private int cap;
  private int first;
  private int last;

  @SuppressWarnings("unchecked")
  public ArrayQueue() {
    len = 0;
    cap = 5;
    first = 0;
    last = 0;
    array = (T[]) new Object[cap];
  }

  @Override
  public void enqueue(final T item) {
    if (len == cap) {
      resize(cap * 2);
    }

    array[last] = item;
    last = (last + 1) % cap;
    len++;
  }

  @Override
  public T dequeue() {
    if (isEmpty()) {
      throw new RuntimeException("Queue is empty");
    }

    T item = array[first];
    array[first] = null;
    first = (first + 1) % cap;
    len--;

    if (len > 0 && len < cap / 4) {
      resize(cap / 2);
    }

    return item;
  }

  @Override
  public boolean isEmpty() {
    return len == 0;
  }

  @Override
  public int size() {
    return len;
  }

  @SuppressWarnings("unchecked")
  private void resize(int max) {
    T[] newArray = (T[]) new Object[max];

    for (int i = 0; i < len; i++) {
      newArray[i] = array[(first + i) % cap];
    }

    first = 0;
    last = len;
    cap = max;
    array = newArray;
  }
}
