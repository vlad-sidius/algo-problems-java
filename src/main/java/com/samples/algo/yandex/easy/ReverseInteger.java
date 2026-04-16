package com.samples.algo.yandex.easy;

/*

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside
the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 */

public class ReverseInteger {

  public int reverse(int x) {
    int k = x < 0 ? -1 : 1;
    int value = Math.abs(x);
    long result = 0;

    while (value > 0) {
      int dig = value % 10;
      result = result * 10 + dig;
      value /= 10;
    }

    result *= k;

    if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
      return 0;
    } else {
      return (int) result;
    }
  }
}
