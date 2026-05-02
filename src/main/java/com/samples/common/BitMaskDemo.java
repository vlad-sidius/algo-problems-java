package com.samples.common;

public class BitMaskDemo {

  static void main() {
    String input1 = "ABCD";
    String input2 = "ACBD";

    IO.println("Input 1: " + input1);
    IO.println("Input 2: " + input2);

    int mask1 = calcMask(input1);
    int mask2 = calcMask(input2);

    if (mask1 == mask2) {
      IO.println("Both bit masks are equal");
    }
  }

  private static int calcMask(String value) {
    int mask = 0;

    for (char ch : value.toCharArray()) {
      mask |= 1 << (ch - 'A');
    }

    return mask;
  }
}
