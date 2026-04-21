package com.samples.algo.yandex.easy;

/*

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result
must be unique and you may return the result in any order.

 */

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> cache = new HashSet<>();

    for (int n : nums1) {
      cache.add(n);
    }

    Set<Integer> intersect = new HashSet<>();

    for (int n : nums2) {
      if (cache.contains(n)) {
        intersect.add(n);
      }
    }

    return intersect.stream().mapToInt(x -> x).toArray();
  }
}
