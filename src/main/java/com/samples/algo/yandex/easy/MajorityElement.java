package com.samples.algo.yandex.easy;

/*

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.

 */

public class MajorityElement {

  // Boyer-Moore Voting Algorithm
  public int majorityElement(int[] nums) {
    int candidate = -1;
    int count = 0;

    for (int n : nums) {
      if (count == 0) {
        candidate = n;
      }

      count += (candidate == n) ? 1 : -1;
    }

    return candidate;
  }
}
