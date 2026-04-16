package com.samples.algo.yandex.easy;

/*

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> cache = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int rem = target - nums[i];

      if (cache.containsKey(rem)) {
        return new int[] {i, cache.get(rem)};
      } else {
        cache.put(nums[i], i);
      }
    }

    return null;
  }
}
