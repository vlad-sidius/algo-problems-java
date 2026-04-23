package com.samples.algo.yandex.easy;

/*

Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 */

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {

  public int firstUniqChar(String s) {
    int result = -1;

    if (s.isEmpty()) {
      return result;
    }

    Map<Character, Integer> cache = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      int count = cache.getOrDefault(ch, 0);
      cache.put(ch, count + 1);
    }

    for (int i = 0; i < s.length(); i++) {
      if (cache.get(s.charAt(i)) == 1) {
        result = i;
        break;
      }
    }

    return result;
  }

  public int firstUniqCharUsingArray(String s) {
    int result = -1;

    if (s.isEmpty()) {
      return result;
    }

    char a = 'a';
    int[] cache = new int[26];

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      cache[ch - a]++;
    }

    for (int i = 0; i < s.length(); i++) {
      if (cache[s.charAt(i) - a] == 1) {
        result = i;
        break;
      }
    }

    return result;
  }
}
