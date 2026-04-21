package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoveZeroesTest {

  private final MoveZeroes instance = new MoveZeroes();

  @Test
  void testBaseCase() {
    int[] array = new int[] { 0,1,0,3,12 };
    int[] expected = new int[] { 1,3,12,0,0 };

    instance.moveZeroes(array);

    assertThat(array).containsExactly(expected);
  }

  @Test
  void testSingleZero() {
    int[] array = new int[] { 0 };
    int[] expected = new int[] { 0 };

    instance.moveZeroes(array);

    assertThat(array).containsExactly(expected);
  }
}
