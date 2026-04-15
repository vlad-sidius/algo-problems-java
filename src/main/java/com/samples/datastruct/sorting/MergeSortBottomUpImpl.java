package com.samples.datastruct.sorting;

public class MergeSortBottomUpImpl<T extends Comparable<T>> extends BaseMergeSort<T> {

  @Override
  @SuppressWarnings("unchecked")
  public void sort(final T[] array) {
    int n = array.length;
    aux = (T[]) new Comparable[n];

    for (int sz = 1; sz < n; sz = sz + sz) {
      for (int lo = 0; lo < n - sz; lo += sz + sz) {
        merge(array, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
      }
    }
  }
}
