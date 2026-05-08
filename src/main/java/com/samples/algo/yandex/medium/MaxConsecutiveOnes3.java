package com.samples.algo.yandex.medium;

/*

Given a binary array nums and an integer k, return the maximum number of consecutive 1's
in the array if you can flip at most k 0's.

 */

public class MaxConsecutiveOnes3 {

  public int longestOnes(int[] nums, int k) {
    int l = 0;
    int zeroCount = 0;
    int maxLen = 0;

    for (int r = 0; r < nums.length; r++) {
      if (nums[r] == 0) {
        zeroCount++;
      }

      while (zeroCount > k) {
        if (nums[l] == 0) {
          zeroCount--;
        }

        l++;
      }

      maxLen = Math.max(maxLen, r - l + 1);
    }

    return maxLen;
  }
}
