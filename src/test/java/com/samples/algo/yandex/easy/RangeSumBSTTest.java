package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode 938: Range Sum of BST")
public class RangeSumBSTTest {

  private final RangeSumBST instance = new RangeSumBST();

  static Stream<Arguments> provideCases() {
        /*
                10
               /  \
              5    15
             / \     \
            3   7     18
        */
    return Stream.of(
        Arguments.of(7, 15, 32),   // 7 + 10 + 15 = 32
        Arguments.of(6, 10, 17),   // 7 + 10 = 17
        Arguments.of(1, 20, 58),   // All nodes: 3+5+7+10+15+18 = 58? Wait: 3+5+7+10+15+18 = 58. Let's fix.
        Arguments.of(15, 18, 33),  // 15 + 18 = 33
        Arguments.of(20, 25, 0),   // Out of range
        Arguments.of(1, 3, 3),     // Only leaf 3
        Arguments.of(5, 5, 5),     // Single node match
        Arguments.of(4, 6, 5)      // Only 5 falls in range
    );
  }

  // Helper to build the canonical LC example tree
  private static TreeNode buildExampleTree() {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(15);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(7);
    root.right.right = new TreeNode(18);

    return root;
  }

  @ParameterizedTest(name = "low={0}, high={1} → expected={2}")
  @MethodSource("provideCases")
  void testRangeSumBST(int low, int high, int expected) {
    TreeNode root = buildExampleTree(); // Same tree for all test cases
    assertEquals(expected, instance.rangeSumBST(root, low, high));
  }
}
