package com.samples.datastruct.simple;

public interface MaxPriorityQueue<T extends Comparable<T>> {

  void insert(T item);
  T max();
  T delMax();
  boolean isEmpty();
  int size();
}
