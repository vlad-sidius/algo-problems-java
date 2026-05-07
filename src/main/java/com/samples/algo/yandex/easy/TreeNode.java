package com.samples.algo.yandex.easy;

public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode() {
    this(0, null, null);
  }

  public TreeNode(final int val) {
    this(val, null, null);
  }

  public TreeNode(final int val, final TreeNode left, final TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
