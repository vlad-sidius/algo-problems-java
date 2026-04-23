package com.samples.algo.yandex.easy;

/*

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
of the characters without disturbing the relative positions of the remaining characters.
(i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 */

public class IsSubsequence {

  public boolean isSubsequence(String s, String t) {
    if (s.isEmpty()) {
      return true;
    }

    if (t.isEmpty()) {
      return false;
    }

    int i = 0;
    int j = 0;

    while (i < t.length() && j < s.length()) {
      if (t.charAt(i) == s.charAt(j)) {
        j++;
      }

      i++;
    }

    return j == s.length();
  }
}
