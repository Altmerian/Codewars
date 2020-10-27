package com.codewars.altmer;

public class StringSplit {
  public static String[] solution(String s) {
    s = (s.length() % 2 != 0) ? s + "_" : s;
    return s.split("(?<=\\G..)");
  }
}
