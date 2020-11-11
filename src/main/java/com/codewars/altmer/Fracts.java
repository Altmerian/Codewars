package com.codewars.altmer;

import com.google.common.annotations.VisibleForTesting;

public class Fracts {

  public static String convertFrac(long[][] lst) {

    // simplifying fractions
    for (long[] fraction : lst) {
      long gcd = findGCD(fraction[0], fraction[1]);
      fraction[0] /= gcd;
      fraction[1] /= gcd;
    }

    // casting to a common denominator
    long lcm = 1L;
    for (long[] fraction : lst) {
      lcm = findLCM(lcm, fraction[1]);
    }
    StringBuilder result = new StringBuilder();
    for (long[] fraction : lst) {
      result
          .append("(")
          .append(fraction[0] * lcm / fraction[1])
          .append(",")
          .append(lcm)
          .append(")");
    }

    return result.toString();
  }

  private static long findLCM(long a, long b) {
    return a * b / findGCD(a, b);
  }

  @VisibleForTesting
  static long findGCD(long a, long b) {
    long min = Math.min(a, b);
    long max = Math.max(a, b);
    long remainder = max % min;
    return (remainder == 0) ? min : findGCD(min, remainder);
  }
}
