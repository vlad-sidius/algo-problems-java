package com.samples.algo.yandex.easy;

/*

Given an integer array nums sorted in non-decreasing order, return an array of the squares of each
number sorted in non-decreasing order.

 */

public class SquaresOfSortedArray {

  public int[] sortedSquares(int[] nums) {
    int[] result = new int[nums.length];
    int l = 0;
    int r = nums.length - 1;
    int k = r;

    while (l <= r) {
      int lval = nums[l] * nums[l];
      int rval = nums[r] * nums[r];

      if (rval > lval) {
        result[k--] = rval;
        r--;
      } else {
        result[k--] = lval;
        l++;
      }
    }

    return result;
  }
}
