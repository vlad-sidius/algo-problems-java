package com.samples.algo.yandex.easy;

/*

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 */

public class MoveZeroes {

  public void moveZeroes(int[] nums) {
    int w = 0;

    for (int r = 0; r < nums.length; r++) {
      if (nums[r] != 0) {
        nums[w++] = nums[r];
      }
    }

    while (w < nums.length) {
      nums[w++] = 0;
    }
  }
}
