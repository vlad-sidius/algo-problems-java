package com.samples.algo.yandex.interview;

import com.samples.algo.yandex.easy.Pair;
import com.samples.algo.yandex.easy.TNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Find Equivalent Subtrees by Character SET")
public class EquivalentSubtreesTest {

  private final EquivalentSubtrees instance = new EquivalentSubtrees();

  static Stream<Arguments> provideCases() {
    return Stream.of(
        // Example from problem: C+ and B+ are equivalent
        Arguments.of(buildExampleTree(), true),
        // Single node: no pair possible
        Arguments.of(buildTree('A'), false),
        // Two identical leaves
        Arguments.of(buildTreeWithChildren('R', 'A', 'A'), true),
        // No equivalents: all subtrees have unique sets
        Arguments.of(buildTreeWithChildren('A', 'B', 'C'), false),
        // Larger tree with multiple equivalents
        Arguments.of(buildComplexTree(), true));
  }

  // Helper: build the example tree from problem statement
  private static TNode buildExampleTree() {
    TNode root = node('A');
    root.left = node('C');
    root.right = node('B');

    root.left.left = node('A');
    root.left.right = node('D');
    root.right.left = node('A');
    root.right.right = node('D');

    root.left.left.left = node('B');
    root.right.right.right = node('C');

    return root;
  }

  private static TNode buildTree(char value) {
    return node(value);
  }

  private static TNode buildTreeWithChildren(char root, char left, char right) {
    TNode r = node(root);
    r.left = node(left);
    r.right = node(right);
    return r;
  }

  private static TNode buildComplexTree() {
    // Tree with multiple equivalent subtrees
    TNode root = node('X');
    root.left = node('A');
    root.right = node('B');
    root.left.left = node('C');
    root.left.right = node('D');
    root.right.left = node('D');
    root.right.right = node('C');
    // {A,C,D} appears twice
    return root;
  }

  private static TNode node(char c) {
    TNode n = new TNode();
    n.value = c;
    return n;
  }

  // Test helper: recompute mask for validation
  private static int getSubtreeMask(TNode node) {
    if (node == null) return 0;
    return getSubtreeMask(node.left) | getSubtreeMask(node.right) | (1 << (node.value - 'A'));
  }

  @ParameterizedTest(name = "tree={0} → expected equivalent pair exists={1}")
  @MethodSource("provideCases")
  void testFindEquivalentSubtrees(TNode root, boolean shouldFindPair) {
    Pair result = instance.findEquivalentSubtrees(root);

    if (shouldFindPair) {
      assertNotNull(result, "Should find an equivalent pair");
      // Verify both nodes have same character set
      assertEquals(getSubtreeMask(result.first()), getSubtreeMask(result.second()));
    } else {
      assertNull(result, "Should not find any equivalent pair");
    }
  }
}
