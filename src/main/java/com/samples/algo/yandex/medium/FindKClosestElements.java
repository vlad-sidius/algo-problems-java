package com.samples.algo.yandex.medium;

import java.util.ArrayList;
import java.util.List;

/*

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b

 */

public class FindKClosestElements {

  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    int l = 0;
    int r = arr.length - k;

    while (l < r) {
      int m = l + (r - l) / 2;

      if (x - arr[m] > arr[m + k] - x) {
         l = m + 1;
      } else {
        r = m;
      }
    }

    List<Integer> result = new ArrayList<>(k);

    for (int i = l; i < l + k; i++) {
      result.add(arr[i]);
    }

    return result;
  }
}
