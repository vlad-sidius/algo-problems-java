package com.samples.datastruct.sorting;

public class ShellSortImpl<T extends Comparable<T>> implements SortingAlgorithm<T> {

  @Override
  public void sort(final T[] array) {
    int n = array.length;
    int gap = 1;

    // calculate max gap
    while (gap < n / 3) {
      gap = gap * 3 + 1;
    }

    while (gap >= 1) {
      for (int i = gap; i < n; i++) {
        for (int j = i; j >= gap && less(array[j], array[j - gap]); j -= gap) {
          swap(array, j, j - gap);
        }
      }

      gap /= 3;
    }
  }
}
