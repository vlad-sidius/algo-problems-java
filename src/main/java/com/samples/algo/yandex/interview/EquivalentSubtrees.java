package com.samples.algo.yandex.interview;

/*

Given a binary tree where each node contains a letter A-Z, find any pair of nodes whose subtrees contain
the same set of letters (ignoring frequency and structure).

Equivalence: Two subtrees are equivalent if the set of characters in them is identical.
Not frequency-based: {A, B, C} ≡ {C, B, A} ≡ {A, A, B, C, C} — only unique letters matter.

 */

import com.samples.algo.yandex.easy.Pair;
import com.samples.algo.yandex.easy.TNode;

import java.util.HashMap;
import java.util.Map;

public class EquivalentSubtrees {

  public Pair findEquivalentSubtrees(TNode root) {
    // DFS post order traversal

    Map<Integer, TNode> cache = new HashMap<>();
    Pair[] result = new Pair[1];

    dfs(root, cache, result);

    return result[0];
  }

  private int dfs(TNode node, Map<Integer, TNode> cache, Pair[] result) {
    if (node == null || result[0] != null) {
      return 0;
    }

    int leftMask = dfs(node.left, cache, result);
    int rightMask = dfs(node.right, cache, result);
    int mask = leftMask | rightMask | (1 << node.value - 'A');

    if (cache.containsKey(mask)) {
      if (result[0] == null) {
        result[0] = new Pair(cache.get(mask), node);
      }
    } else {
      cache.put(mask, node);
    }

    return mask;
  }
}
