package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("101. Symmetric Tree")
public class SymmetricTreeTest {

  private final SymmetricTree instance = new SymmetricTree();

  static Stream<Arguments> provideCases() {
    return Stream.of(
        Arguments.of(buildTree(1, 2, 2, 3, 4, 4, 3), true),   // Classic symmetric
        Arguments.of(buildTree(1, 2, 2, null, 3, null, 3), false), // Asymmetric subtrees
        Arguments.of(buildTree(1), true),               // Single node
        Arguments.of(buildTree(1, 2, 3), false),          // Different children
        Arguments.of(buildTree(1, 2, 2, 3, null, null, 3), false), // Structure mismatch
        Arguments.of(buildTree(5, 4, 4, null, 2, null, 2), true),  // Valid with nulls
        Arguments.of(buildTree(1, 2, 2, 2, null, 2), false)  // Value/structure mix
    );
  }

  private static TreeNode buildTree(Integer... vals) {
    if (vals == null || vals.length == 0 || vals[0] == null) {
      return null;
    }

    TreeNode root = new TreeNode(vals[0]);
    Deque<TreeNode> q = new ArrayDeque<>();
    q.add(root);

    int i = 1;

    while (!q.isEmpty() && i < vals.length) {
      TreeNode curr = q.poll();

      if (vals[i] != null) {
        curr.left = new TreeNode(vals[i]);
        q.add(curr.left);
      }

      i++;

      if (i < vals.length && vals[i] != null) {
        curr.right = new TreeNode(vals[i]);
        q.add(curr.right);
      }

      i++;
    }

    return root;
  }

  @ParameterizedTest(name = "tree={0} → expected={1}")
  @MethodSource("provideCases")
  void testIsSymmetric(TreeNode root, boolean expected) {
    assertEquals(expected, instance.isSymmetric(root));
  }
}
