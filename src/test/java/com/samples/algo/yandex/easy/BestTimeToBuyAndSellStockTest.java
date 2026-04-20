package com.samples.algo.yandex.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BestTimeToBuyAndSellStockTest {

  private final BestTimeToBuyAndSellStock instance = new BestTimeToBuyAndSellStock();

  @Test
  void testMaxProfit() {
    int[] prices = new int[] { 7,1,5,3,6,4 };
    int expected = 5;

    int actual = instance.maxProfit(prices);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void testNoProfit() {
    int[] prices = new int[] { 7,6,4,3,1 };
    int expected = 0;

    int actual = instance.maxProfit(prices);

    assertThat(actual).isEqualTo(expected);
  }
}
