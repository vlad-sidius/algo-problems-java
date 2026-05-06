package com.samples.algo.yandex.easy;

/*

Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
You must also not convert the inputs to integers directly.

Constraints:

1 <= num1.length, num2.length <= 104
num1 and num2 consist of only digits.
num1 and num2 don't have any leading zeros except for the zero itself.

 */

public class AddStrings {

  public String addStrings(String num1, String num2) {
    int i = num1.length() - 1;
    int j = num2.length() - 1;
    int carry = 0;

    int maxLen = Math.max(num1.length(), num2.length());
    char[] result = new char[maxLen + 1];
    int k = maxLen;

    while (i >= 0 || j >= 0) {
      int n1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
      int n2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;
      int current = n1 + n2 + carry;

      result[k--] = (char) (current % 10 + '0');
      carry = current / 10;
    }

    if (carry > 0) {
      result[k] = (char) (carry + '0');
      return new String(result);
    } else {
      return new String(result, 1, result.length - 1);
    }
  }
}
