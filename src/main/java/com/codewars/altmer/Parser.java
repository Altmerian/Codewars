package com.codewars.altmer;

import java.util.HashMap;
import java.util.Map;

public class Parser {
  public static int parseInt(String numStr) {
    numStr = numStr.strip().replace(" and", "").toLowerCase();
    String[] tokens = numStr.split(" |-");

    int number = 0;

    Map<String, Integer> map = new HashMap<>();
    map.put("zero", 0);
    map.put("one", 1);
    map.put("two", 2);
    map.put("three", 3);
    map.put("four", 4);
    map.put("five", 5);
    map.put("six", 6);
    map.put("seven", 7);
    map.put("eight", 8);
    map.put("nine", 9);
    map.put("ten", 10);
    map.put("eleven", 11);
    map.put("twelve", 12);
    map.put("thirteen", 13);
    map.put("fourteen", 14);
    map.put("fifteen", 15);
    map.put("sixteen", 16);
    map.put("seventeen", 17);
    map.put("eighteen", 18);
    map.put("nineteen", 19);
    map.put("twenty", 20);
    map.put("thirty", 30);
    map.put("forty", 40);
    map.put("fifty", 50);
    map.put("sixty", 60);
    map.put("seventy", 70);
    map.put("eighty", 80);
    map.put("ninety", 90);
    map.put("hundred", 100);
    map.put("thousand", 1000);
    map.put("million", 1000000);

    for (String token : tokens) {
      if (map.get(token) > 100) {
        number *= map.get(token);
      } else if (map.get(token) == 100) {
        int temp = number % 10;
        number -= temp;
        number += temp * 100;
      } else {
        number += map.get(token);
      }
    }

    return number;
  }
}
