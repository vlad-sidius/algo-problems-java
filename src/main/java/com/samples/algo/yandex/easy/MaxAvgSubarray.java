package com.samples.algo.yandex.easy;

/*

You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
Any answer with a calculation error less than 10-5 will be accepted.

 */

public class MaxAvgSubarray {

  public double findMaxAverage(int[] nums, int k) {
    int sum = 0;
    double avg = 0.0;
    double maxAvg = 0.0;

    for (int i = 0; i < k; i++) {
      sum += nums[i];
    }

    maxAvg = (double) sum / k;

    for (int i = 1; i <= nums.length - k; i++) {
      sum = sum - nums[i - 1] + nums[i + k - 1];
      avg = (double) sum / k;
      maxAvg = Math.max(maxAvg, avg);
    }

    return maxAvg;
  }
}
