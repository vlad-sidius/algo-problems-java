package com.samples.datastruct.sorting;

public class MergeSortImpl<T extends Comparable<T>> extends BaseMergeSort<T> {

  @Override
  @SuppressWarnings("unchecked")
  public void sort(final T[] array) {
    aux = (T[]) new Comparable[array.length];
    sort(array, 0, array.length - 1);
  }

  private void sort(T[] array, int lo, int hi) {
    if (lo >= hi) {
      return;
    }

    int mid = lo + (hi - lo) / 2;

    sort(array, lo, mid);
    sort(array, mid + 1, hi);
    merge(array, lo, mid, hi);
  }
}
