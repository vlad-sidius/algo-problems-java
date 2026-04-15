package com.samples.datastruct.sorting;

public class InsertionSortImpl<T extends Comparable<T>> implements SortingAlgorithm<T> {

  @Override
  public void sort(final T[] array) {
    if (array.length <= 1) {
      return;
    }

    for (int i = 1; i < array.length; i++) {
      for (int j = i; j > 0 && less(array[j], array[j - 1]); j--) {
        swap(array, j, j - 1);
      }
    }
  }
}
