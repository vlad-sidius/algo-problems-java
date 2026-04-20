package com.samples.algo.yandex.easy;

/*

Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique
element appears only once. The relative order of the elements should be kept the same.

Consider the number of unique elements in nums to be k. After removing duplicates,
return the number of unique elements k.

The first k elements of nums should contain the unique numbers in sorted order.
The remaining elements beyond index k - 1 can be ignored.

 */

public class DeduplicateSortedArray {

  public int removeDuplicates(int[] nums) {
    int n = nums.length;

    if (n <= 1) {
      return n;
    }

    int i = 0;
    int j = 0;

    while (j < n) {
      while (j < (n - 1) && nums[j] == nums[j + 1]) {
        j++;
      }

      nums[i] = nums[j];

      i++;
      j++;
    }

    return i;
  }
}
