package com.samples.algo.yandex.easy;

/*

Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.

 */

public class ValidPalindromeTwo {

  public boolean validPalindrome(String s) {
    int l = 0;
    int r = s.length() - 1;

    while (l < r) {
      if (s.charAt(l) != s.charAt(r)) {
        return isPalindrome(s, l, r - 1) || isPalindrome(s, l + 1, r);
      }

      l++;
      r--;
    }

    return true;
  }

  private boolean isPalindrome(String s, int l, int r) {
    while (l < r) {
      if (s.charAt(l) != s.charAt(r)) {
        return false;
      }

      l++;
      r--;
    }

    return true;
  }
}
