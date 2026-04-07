package com.samples.algo.easy;

/*

You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately,
due to some error, one of the numbers in s got duplicated to another number in the set,
which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.
Find the number that occurs twice and the number that is missing and return them in the form of an array.

 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetMismatch {

  public static int[] findErrorNumsWithSet(int[] nums) {
    int len = nums.length;
    int idealSum = (len + 1) * len / 2;
    int sum = 0;

    for (int n : nums) {
      sum += n;
    }

    Set<Integer> uniqueNums = new HashSet<>();

    for (int n : nums) {
      uniqueNums.add(n);
    }

    int uniqueSum = 0;

    for (int n : uniqueNums) {
      uniqueSum += n;
    }

    return new int[] {sum - uniqueSum, idealSum - uniqueSum};
  }

  public static int[] findErrorNumsWithMap(int[] nums) {
    Map<Integer, Integer> counts = new HashMap<>();
    int[] result = new int[] {0, 0};

    for (int n : nums) {
      counts.put(n, counts.getOrDefault(n, 0) + 1);
    }

    for (int i = 1; i <= nums.length; i++) {
      int count = counts.getOrDefault(i, 0);

      if (count == 2) {
        result[0] = i;
      } else if (count == 0) {
        result[1] = i;
      }
    }

    return result;
  }

  public static int[] findErrorNumsInPlace(int[] nums) {
    int dup = 0, miss = 0;

    for (int i = 0; i < nums.length; i++) {
      int n = Math.abs(nums[i]) - 1;

      if (nums[n] < 0) {
        dup = n + 1;
      } else {
        nums[n] *= -1;
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        miss = i + 1;
      }
    }

    return new int[] {dup, miss};
  }
}
