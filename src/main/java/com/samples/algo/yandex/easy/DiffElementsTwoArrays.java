package com.samples.algo.yandex.easy;

/*

Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiffElementsTwoArrays {

  public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    Set<Integer> cache1 = new HashSet<>();
    Set<Integer> cache2 = new HashSet<>();

    for (int n : nums1) {
      cache1.add(n);
    }

    for (int n : nums2) {
      cache2.add(n);
    }

    Set<Integer> answer1 = new HashSet<>();
    Set<Integer> answer2 = new HashSet<>();

    for (int n : nums1) {
      if (!cache2.contains(n)) {
        answer1.add(n);
      }
    }

    for (int n : nums2) {
      if (!cache1.contains(n)) {
        answer2.add(n);
      }
    }

    return List.of(new ArrayList<>(answer1), new ArrayList<>(answer2));
  }
}
