package com.samples.datastruct.simple;

import java.util.NoSuchElementException;

public class MaxPriorityQueueImpl<T extends Comparable<T>> implements MaxPriorityQueue<T> {

  int n = 0;
  T[] pq;

  @SuppressWarnings("unchecked")
  public MaxPriorityQueueImpl(final int n) {
    this.pq = (T[]) new Comparable[n + 1];
  }

  @Override
  public void insert(final T item) {
    if (item == null) {
      throw new NullPointerException();
    }

    if (n == pq.length - 1) {
      resize(pq.length * 2);
    }

    pq[++n] = item;
    siftUp(n);
  }

  @Override
  public T max() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    return pq[1];
  }

  @Override
  public T delMax() {
    T max = max();
    swap(1, n);
    pq[n--] = null;
    siftDown(1);

    return max;
  }

  @Override
  public boolean isEmpty() {
    return n == 0;
  }

  @Override
  public int size() {
    return n;
  }

  private boolean less(int i, int j) {
    return pq[i].compareTo(pq[j]) < 0;
  }

  private void swap(int i, int j) {
    T temp = pq[i];
    pq[i] = pq[j];
    pq[j] = temp;
  }

  private void siftUp(int i) {
    while (i > 1 && less(i / 2, i)) {
      swap(i / 2, i);
      i /= 2;
    }
  }

  private void siftDown(int i) {
    while (i * 2 <= n) {
      int j = i * 2;

      if (j < n && less(j, j + 1)) {
        j++;
      }

      if (!less(i, j)) {
        break;
      }

      swap(i, j);
      i = j;
    }
  }

  @SuppressWarnings("unchecked")
  private void resize(int max) {
    T[] resized = (T[]) new Comparable[max];
    System.arraycopy(pq, 0, resized, 0, n + 1);

    pq = resized;
  }
}
