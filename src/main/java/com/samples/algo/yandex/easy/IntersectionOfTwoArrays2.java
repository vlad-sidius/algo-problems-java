package com.samples.algo.yandex.easy;

/*

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result
must appear as many times as it shows in both arrays and you may return the result in any order.

 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArrays2 {

  public int[] intersect(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      return intersect(nums2, nums1);
    }

    Map<Integer, Integer> cache = new HashMap<>();

    for (int n : nums1) {
      int count = cache.getOrDefault(n, 0);
      cache.put(n, count + 1);
    }

    int k = 0;

    for (int n : nums2) {
      int count = cache.getOrDefault(n, 0);

      if (count > 0) {
        nums1[k++] = n;
        cache.put(n, count - 1);
      }
    }

    return Arrays.copyOfRange(nums1, 0, k);
  }
}
