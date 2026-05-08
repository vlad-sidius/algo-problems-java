package com.samples.algo.yandex.interview;

/*

Given an array of integers, find the longest strictly monotonic subarray (either strictly increasing
OR strictly decreasing) and return its start and end indices (0-based).

Strictly increasing: a[i] < a[i+1] for all consecutive pairs
Strictly decreasing: a[i] > a[i+1] for all consecutive pairs
Equal elements break monotonicity

 */

public class MaxMonotonicSubarray {

  public int[] maxMonotonic(int[] a) {
    if (a == null || a.length == 0) {
      return new int[0];
    }

    if (a.length == 1) {
      return new int[] { 0, 0 };
    }

    int maxIncrLen = 1;
    int maxIncrStart = 0;
    int cIncrLen = 1;
    int cIncrStart = 0;

    for (int i = 1; i < a.length; i++) {
      if (a[i] > a[i - 1]) {
        cIncrLen++;

        if (cIncrLen > maxIncrLen) {
          maxIncrLen = cIncrLen;
          maxIncrStart = cIncrStart;
        }
      } else {
        cIncrStart = i;
        cIncrLen = 1;
      }
    }

    int maxDecLen = 1;
    int maxDecStart = 0;
    int cDecLen = 1;
    int cDecStart = 0;

    for (int i = 1; i < a.length; i++) {
      if (a[i] < a[i - 1]) {
        cDecLen++;

        if (cDecLen > maxDecLen) {
          maxDecLen = cDecLen;
          maxDecStart = cDecStart;
        }
      } else {
        cDecStart = i;
        cDecLen = 1;
      }
    }

    return (maxIncrLen >= maxDecLen)
        ? new int[] { maxIncrStart, maxIncrStart + maxIncrLen - 1 }
        : new int[] { maxDecStart, maxDecStart + maxDecLen - 1 };
  }
}
