package com.samples.algo.yandex.easy;

/*

Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east,
or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.

Return true if the path crosses itself at any point, that is, if at any time you are on a location you
have previously visited. Return false otherwise.

Constraints:

1 <= path.length <= 104
path[i] is either 'N', 'S', 'E', or 'W'.

 */

import java.util.HashSet;
import java.util.Set;

public class PathCrossing {

  public boolean isPathCrossing(String path) {
    int x = 0;
    int y = 0;

    Set<String> visited = new HashSet<>(path.length());
    visited.add("0,0");

    for (char ch : path.toCharArray()) {
      switch (ch) {
        case 'N' -> y += 1;
        case 'S' -> y -= 1;
        case 'E' -> x += 1;
        case 'W' -> x -= 1;
      }

      String entry = x + "," + y;

      if (visited.contains(entry)) {
        return true;
      }

      visited.add(entry);
    }

    return false;
  }
}
