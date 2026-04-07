package com.samples.algo.easy;

public class StringPalindrome {

  public static boolean isPalindrome(String s) {
    if (s.length() <= 1) {
      return true;
    }

    int i = 0;
    int j = s.length() - 1;

    while (i < j) {
      while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
        i++;
      }

      while (j > i && !Character.isLetterOrDigit(s.charAt(j))) {
        j--;
      }

      if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
        return false;
      }

      i++;
      j--;
    }

    return true;
  }
}
