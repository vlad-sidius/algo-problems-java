package com.samples.datastruct.sorting;

public class SelectionSortImpl<T extends Comparable<T>> implements SortingAlgorithm<T> {

  @Override
  public void sort(final T[] array) {
    for (int i = 0; i < array.length; i++) {
      int minIdx = i;

      for (int j = i; j < array.length; j++) {
        if (less(array[j], array[minIdx])) {
          minIdx = j;
        }
      }

      swap(array, i, minIdx);
    }
  }
}
