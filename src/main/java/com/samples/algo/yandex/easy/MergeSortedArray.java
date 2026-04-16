package com.samples.algo.yandex.easy;

/*

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 */

public class MergeSortedArray {

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] aux = new int[m];

    System.arraycopy(nums1, 0, aux, 0, m);

    int i = 0;
    int j = 0;
    int k = 0;

    while (i < m && j < n) {
      if (aux[i] <= nums2[j]) {
        nums1[k++] = aux[i++];
      } else {
        nums1[k++] = nums2[j++];
      }
    }

    while (i < m) {
      nums1[k++] = aux[i++];
    }

    while (j < n) {
      nums1[k++] = nums2[j++];
    }
  }
}
