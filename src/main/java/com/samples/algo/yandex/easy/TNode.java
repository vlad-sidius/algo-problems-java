package com.samples.algo.yandex.easy;

public class TNode {
  public char value;
  public TNode left;
  public TNode right;

  public TNode() {
    this('A', null, null);
  }

  public TNode(final char val) {
    this(val, null, null);
  }

  public TNode(final char val, final TNode left, final TNode right) {
    this.value = val;
    this.left = left;
    this.right = right;
  }
}
