package com.codewars.altmer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SumDigPowerTest {

  private final long a;
  private final long b;
  private final long[] res;

  public SumDigPowerTest(long a, long b, long[] res) {
    this.a = a;
    this.b = b;
    this.res = res;
  }

  @Parameterized.Parameters(name = "{index}. {0}-{1}: {2}")
  public static Object[][] data() {
    return new Object[][] {
      {1, 10, new long[] {1, 2, 3, 4, 5, 6, 7, 8, 9}},
      {1, 100, new long[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 89}},
      {10, 100, new long[] {89}},
      {90, 100, new long[] {}},
      {90, 150, new long[] {135}},
      {50, 150, new long[] {89, 135}},
      {10, 150, new long[] {89, 135}}
    };
  }

  @Test
  public void testing() {
    assertEquals(Arrays.toString(res), Arrays.toString(SumDigPower.sumDigPow(a, b).toArray()));
  }
}
