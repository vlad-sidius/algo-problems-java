package com.samples.algo.yandex.medium;

/*



 */

import com.samples.algo.yandex.easy.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    List<TreeNode> result = new ArrayList<>();
    dfs(root, new HashMap<>(), result);

    return result;
  }

  private String dfs(TreeNode node, Map<String, Integer> cache, List<TreeNode> result) {
    if (node == null) {
      return "#";
    }

    String repr = "(" + dfs(node.left, cache, result) + ")" +
                  node.val +
                  "(" + dfs(node.right, cache, result) +
                  ")";

    cache.put(repr, cache.getOrDefault(repr, 0) + 1);

    if (cache.get(repr) == 2) {
      result.add(node);
    }

    return repr;
  }
}
