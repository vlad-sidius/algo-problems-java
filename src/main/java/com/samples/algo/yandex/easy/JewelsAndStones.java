package com.samples.algo.yandex.easy;

/*

You're given strings jewels representing the types of stones that are jewels, and stones representing the stones
you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have
are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".

 */

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

  public int numJewelsInStones(String jewels, String stones) {
    Set<Character> jewelSet = new HashSet<>();

    for (char ch : jewels.toCharArray()) {
      jewelSet.add(ch);
    }

    int count = 0;

    for (char ch : stones.toCharArray()) {
      if (jewelSet.contains(ch)) {
        count++;
      }
    }

    return count;
  }
}
