package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JewelsAndStonesTest {

  private final JewelsAndStones solution = new JewelsAndStones();

  @Test
  void testBaseCase() {
    String jewels = "aA";
    String stones = "aAAbbbb";
    int expected = 3;

    int actual = solution.numJewelsInStones(jewels, stones);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testNoJewelsCase() {
    String jewels = "z";
    String stones = "ZZ";
    int expected = 0;

    int actual = solution.numJewelsInStones(jewels, stones);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testEmptyJewels() {
    String jewels = "";
    String stones = "aAAbbbb";
    int expected = 0;

    int actual = solution.numJewelsInStones(jewels, stones);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testEmptyStones() {
    String jewels = "aA";
    String stones = "";
    int expected = 0;

    int actual = solution.numJewelsInStones(jewels, stones);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testEmptyJewelsAndStones() {
    String jewels = "";
    String stones = "";
    int expected = 0;

    int actual = solution.numJewelsInStones(jewels, stones);
    assertThat(actual).isEqualTo(expected);
  }
}
