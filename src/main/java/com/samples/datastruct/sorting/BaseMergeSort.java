package com.samples.datastruct.sorting;

public abstract class BaseMergeSort<T extends Comparable<T>> implements SortingAlgorithm<T> {

  protected T[] aux;

  protected void merge(T[] array, int lo, int mid, int hi) {
    System.arraycopy(array, lo, aux, lo, hi - lo + 1);

    int i = lo;
    int j = mid + 1;

    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        array[k] = aux[j++];
      } else if (j > hi) {
        array[k] = aux[i++];
      } else if (less(aux[i], aux[j])) {
        array[k] = aux[i++];
      } else {
        array[k] = aux[j++];
      }
    }
  }
}
