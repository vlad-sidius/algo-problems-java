package com.samples.algo.yandex.easy;

/*

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters.
No two characters may map to the same character, but a character may map to itself.

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.

 */

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

  public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> mapST = new HashMap<>();
    Map<Character, Character> mapTS = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char c1 = s.charAt(i);
      char c2 = t.charAt(i);

      if (mapST.containsKey(c1) && mapST.get(c1) != c2) {
        return false;
      }

      if (mapTS.containsKey(c2) && mapTS.get(c2) != c1) {
        return false;
      }

      mapST.put(c1, c2);
      mapTS.put(c2, c1);
    }

    return true;
  }
}
