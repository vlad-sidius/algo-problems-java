package com.samples.algo.easy;

/*

  Given an integer x, return true if x is a palindrome, and false otherwise.

 */

public class NumberPalindrome {

  public static boolean isPalindrome(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }

    int reversed = 0;

    while (x > reversed) {
      int digit = x % 10;
      reversed = reversed * 10 + digit;
      x /= 10;
    }

    return x == reversed || x == reversed / 10;
  }
}
