package com.samples.datastruct.sorting;

public class QuickSortImpl<T extends Comparable<T>> implements SortingAlgorithm<T> {

  @Override
  public void sort(final T[] array) {
    sort(array, 0, array.length - 1);
  }

  private void sort(T[] array, int lo, int hi) {
    if (lo >= hi) {
      return;
    }

    int mid = partition(array, lo, hi);
    sort(array, lo, mid - 1);
    sort(array, mid + 1, hi);
  }

  private int partition(T[] array, int lo, int hi) {
    int i = lo;
    int j = hi + 1;
    T v = array[lo];

    while (true) {
      while (less(array[++i], v)) {
        if (i == hi) {
          break;
        }
      }

      while (less(v, array[--j])) {
        if (j == lo) {
          break;
        }
      }

      if (i >= j) {
        break;
      }

      swap(array, i, j);
    }

    swap(array, lo, j);

    return j;
  }
}
