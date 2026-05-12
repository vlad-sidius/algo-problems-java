package com.samples.algo.yandex.medium;

/*

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.

 */

import java.util.Arrays;

public class PermutationInString {

  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }

    int[] countsS1 = new int[26];
    int[] countsS2 = new int[26];

    for (int i = 0; i < s1.length(); i++) {
      countsS1[s1.charAt(i) - 'a']++;
      countsS2[s2.charAt(i) - 'a']++;
    }

    if (Arrays.equals(countsS1, countsS2)) {
      return true;
    }

    int len1 = s1.length();

    for (int i = len1; i < s2.length(); i++) {
      countsS2[s2.charAt(i - len1) - 'a']--;
      countsS2[s2.charAt(i) - 'a']++;

      if (Arrays.equals(countsS1, countsS2)) {
        return true;
      }
    }

    return false;
  }
}
