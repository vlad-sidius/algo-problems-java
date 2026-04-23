package com.samples.algo.yandex.easy;

/*

Given an unsorted array of integers nums, return the length of the longest continuous increasing
subsequence (i.e. subarray). The subsequence must be strictly increasing.

A continuous increasing subsequence is defined by two indices l and r (l < r) such that
it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].

 */

public class LongestContinuousIncreasingSubsequence {

  public int findLengthOfLCIS(int[] nums) {
    int j = 0;
    int maxLen = 0;

    for (int i = 0; i < nums.length; i++) {
      j = i;

      while (j < nums.length - 1 && nums[j + 1] > nums[j]) {
        j++;
      }

      maxLen = Math.max(maxLen, j - i + 1);
    }

    return maxLen;
  }
}
