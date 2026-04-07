package com.samples.datastruct.simple;

public class ArrayStack<T> implements Stack<T> {

  private int n;
  private T[] array;

  @SuppressWarnings("unchecked")
  public ArrayStack() {
    array = (T[]) new Object[1];
    n = 0;
  }

  @Override
  public void push(final T item) {
    if (n == array.length) {
      resize(n * 2);
    }

    array[n++] = item;
  }

  @Override
  public T pop() {
    if (isEmpty()) {
      throw new RuntimeException("Stack is empty");
    }

    T item = array[--n];
    array[n] = null;

    if (n < array.length / 4) {
      resize(array.length / 2);
    }

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

  @SuppressWarnings("unchecked")
  private void resize(int max) {
    T[] resized = (T[]) new Object[max];
    System.arraycopy(array, 0, resized, 0, n);

    array = resized;
  }
}
