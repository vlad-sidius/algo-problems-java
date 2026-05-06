package com.samples.algo.yandex.easy;

/*

You are given two 2D integer arrays nums1 and nums2.

nums1[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
nums2[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
Each array contains unique ids and is sorted in ascending order by id.

Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:

Only ids that appear in at least one of the two arrays should be included in the resulting array.
Each id should be included only once and its value should be the sum of the values of this id in the two arrays.
If the id does not exist in one of the two arrays, then assume its value in that array to be 0.

Return the resulting array. The returned array must be sorted in ascending order by id.

 */

import java.util.ArrayList;
import java.util.List;

public class MergeSumming2dArrays {

  public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
    List<int[]> result = new ArrayList<>(nums1.length + nums2.length);

    int i = 0;
    int j = 0;

    while (i < nums1.length && j < nums2.length) {
      if (nums1[i][0] < nums2[j][0]) {
        result.add(nums1[i]);
        i++;
      } else if (nums1[i][0] > nums2[j][0]) {
        result.add(nums2[j]);
        j++;
      } else {
        result.add(new int[] {nums1[i][0], nums1[i][1] + nums2[j][1]});
        i++;
        j++;
      }
    }

    while (i < nums1.length) {
      result.add(nums1[i++]);
    }

    while (j < nums2.length) {
      result.add(nums2[j++]);
    }

    return result.toArray(new int[0][2]);
  }
}
