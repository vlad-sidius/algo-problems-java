package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IsSubsequenceTest {

  private final IsSubsequence instance = new IsSubsequence();

  @Test
  void testSubsequence() {
    String s = "abc";
    String t = "ahbgdc";

    boolean actual = instance.isSubsequence(s, t);

    assertThat(actual).isTrue();
  }

  @Test
  void testNotSubsequence() {
    String s = "axc";
    String t = "ahbgdc";

    boolean actual = instance.isSubsequence(s, t);

    assertThat(actual).isFalse();
  }

  @Test
  void testEmptySubsequence() {
    String s = "";
    String t = "ahbgdc";

    boolean actual = instance.isSubsequence(s, t);

    assertThat(actual).isTrue();
  }

  @Test
  void testEmptySequence() {
    String s = "asx";
    String t = "";

    boolean actual = instance.isSubsequence(s, t);

    assertThat(actual).isFalse();
  }
}
