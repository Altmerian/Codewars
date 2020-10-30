package com.codewars.altmer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class SumDigPower {

  public static List<Long> sumDigPow(long a, long b) {
    return LongStream.rangeClosed(a, b)
        .filter(n -> n == getDigPow(n))
        .boxed()
        .collect(Collectors.toList());
  }

  private static long getDigPow(long n) {
    String s = String.valueOf(n);
    long sum = 0;
    for (int i = 0; i < s.length(); i++) {
      sum += Math.pow(Character.getNumericValue(s.charAt(i)), i + 1);
    }
    return sum;
  }
}
