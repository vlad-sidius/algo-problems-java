package com.samples.algo.yandex.easy;

/*

Given the array of integers nums, you will choose two different indices i and j of that array.
Return the maximum value of (nums[i]-1)*(nums[j]-1).

 */

public class MaxTwoProductInArray {

  public int maxProduct(int[] nums) {
    int max = 0;
    int next = 0;

    for (int n : nums) {
      if (n > max) {
        next = max;
        max = n;
      } else if (n > next) {
        next = n;
      }
    }

    return (max - 1) * (next - 1);
  }
}
