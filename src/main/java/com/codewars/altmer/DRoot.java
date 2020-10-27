package com.codewars.altmer;

public class DRoot {
  public static int digital_root(int n) {
    n = Math.abs(n);

    if (n < 10) {
      return n;
    } else {
      n = findDigitsSum(n);
      return digital_root(n);
    }
//    single line solution
//    return (n != 0 && n%9 == 0) ? 9 : n % 9;
  }

  private static int findDigitsSum(int number) {
    if (number < 10) {
      return number;
    } else {
      return number % 10 + findDigitsSum(number / 10);
    }
  }
}
