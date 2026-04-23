package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FirstUniqueCharacterInStringTest {

  private final FirstUniqueCharacterInString instance = new FirstUniqueCharacterInString();

  @Test
  void testExistsCase1() {
    String text = "leetcode";
    int expected = 0;

    int actual = instance.firstUniqCharUsingArray(text);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testExistsCase2() {
    String text = "loveleetcode";
    int expected = 2;

    int actual = instance.firstUniqCharUsingArray(text);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testMissingCase() {
    String text = "aabb";
    int expected = -1;

    int actual = instance.firstUniqCharUsingArray(text);

    assertThat(actual).isEqualTo(expected);
  }
}
