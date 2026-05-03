package com.samples.algo.yandex.easy;

/*

You are given two integer arrays nums1 and nums2 of sizes n and m, respectively. Calculate the following values:

answer1 : the number of indices i such that nums1[i] exists in nums2.
answer2 : the number of indices i such that nums2[i] exists in nums1.
Return [answer1,answer2].

Constraints:

n == nums1.length
m == nums2.length
1 <= n, m <= 100
1 <= nums1[i], nums2[i] <= 100

 */

public class CommonElementsTwoArrays {

  public int[] findIntersectionValues(int[] nums1, int[] nums2) {
    boolean[] cache1 = new boolean[101];
    boolean[] cache2 = new boolean[101];

    for (int n : nums1) {
      cache1[n] = true;
    }

    for (int n : nums2) {
      cache2[n] = true;
    }

    int answer1 = 0;
    int answer2 = 0;

    for (int n : nums1) {
      if (cache2[n]) {
        answer1++;
      }
    }

    for (int n : nums2) {
      if (cache1[n]) {
        answer2++;
      }
    }

    return new int[] {answer1, answer2};
  }
}
