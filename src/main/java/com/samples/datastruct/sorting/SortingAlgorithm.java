package com.samples.datastruct.sorting;

public interface SortingAlgorithm<T extends Comparable<T>> {

  void sort(T[] array);

  default boolean less(T first, T second) {
    return first.compareTo(second) < 0;
  }

  default void swap(T[] array, int i, int j) {
    T temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  default boolean isSorted(T[] array) {
    if (array.length <= 1) {
      return true;
    }

    for (int i = 1; i < array.length; i++) {
      if (array[i - 1].compareTo(array[i]) > 0) {
        return false;
      }
    }

    return true;
  }
}
