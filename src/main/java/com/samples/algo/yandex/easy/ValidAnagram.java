package com.samples.algo.yandex.easy;

/*

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

 */

public class ValidAnagram {

  public boolean isAnagram(String s, String t) {
    int[] freq = new int[26];

    if (s.length() != t.length()) {
      return false;
    }

    for (int i = 0; i < s.length(); i++) {
      freq[s.charAt(i) - 'a']++;
      freq[t.charAt(i) - 'a']--;
    }

    for (int i = 0; i < freq.length; i++) {
      if (freq[i] != 0) {
        return false;
      }
    }

    return true;
  }
}
