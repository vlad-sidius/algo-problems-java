package com.samples.algo.yandex.easy;

/*

You are given an array of integers nums. Return the length of the longest subarray of nums which
is either strictly increasing or strictly decreasing.

 */

public class MaxMonotonicSubarray {

  public int longestMonotonicSubarray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    if (nums.length == 1) {
      return 1;
    }

    int maxLen = 0;
    int incr = 1;
    int decr = 1;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] < nums[i]) {
        incr++;
        decr = 1;
      } else if (nums[i - 1] > nums[i]) {
        decr++;
        incr = 1;
      } else {
        incr = 1;
        decr = 1;
      }

      maxLen = Math.max(maxLen, Math.max(incr, decr));
    }

    return maxLen;
  }
}
