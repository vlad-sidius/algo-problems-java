package com.samples.datastruct.sorting;

public class QuickSort3WayImpl<T extends Comparable<T>> implements SortingAlgorithm<T> {

  @Override
  public void sort(final T[] array) {
    sort(array, 0, array.length - 1);
  }

  private void sort(T[] array, int lo, int hi) {
    if (lo >= hi) {
      return;
    }

    int lt = lo;
    int gt = hi;
    int i = lo + 1;
    T v = array[lo];

    while (i <= gt) {
      int cmp = v.compareTo(array[i]);

      if (cmp > 0) {
        swap(array, lt++, i++);
      } else if (cmp < 0) {
        swap(array, i, gt--);
      } else {
        i++;
      }
    }

    sort(array, lo, lt - 1);
    sort(array, gt + 1, hi);
  }
}
