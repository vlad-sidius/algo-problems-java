package com.samples.algo.yandex.easy;

/*

Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of
the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do
the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
The remaining elements of nums are not important as well as the size of nums.
Return k.

 */

public class RemoveElement {

  public int removeElement(int[] nums, int val) {
    if (nums.length == 0) {
      return 0;
    }

    int l = 0;
    int r = nums.length - 1;
    int count = 0;

    while (l <= r) {
      while (l < nums.length && nums[l] != val) {
        count++;
        l++;
      }

      while (r > 0 && nums[r] == val) {
        r--;
      }

      if (l < r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;

        l++;
        r--;
        count++;
      } else {
        break;
      }
    }

    return count;
  }
}
