package com.samples.algo.yandex.easy;

/*

An array is monotonic if it is either monotone increasing or monotone decreasing.

An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing
if for all i <= j, nums[i] >= nums[j].

Given an integer array nums, return true if the given array is monotonic, or false otherwise.

 */

public class MonotonicArray {

  public boolean isMonotonic(int[] nums) {
    boolean isIncrease = true;
    boolean isDecrease = true;

    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] > nums[i + 1]) {
        isIncrease = false;
      }

      if (nums[i] < nums[i + 1]) {
        isDecrease = false;
      }

      if (!isIncrease && !isDecrease) {
        break;
      }
    }

    return isIncrease || isDecrease;
  }
}
