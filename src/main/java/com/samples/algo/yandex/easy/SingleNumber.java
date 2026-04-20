package com.samples.algo.yandex.easy;

/*

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 */

import java.util.Arrays;

public class SingleNumber {

  public int singleNumber(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }

    Arrays.sort(nums);

    int i = 0;

    while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
      i += 2;
    }

    return nums[i];
  }
}
