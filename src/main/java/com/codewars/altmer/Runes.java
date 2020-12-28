package com.codewars.altmer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runes {
  public static int solveExpression(final String expression) {
    int missingDigit = -1;

    for (int i = 0; i < 10; i++) {
      char digit = Character.forDigit(i, 10);

      String expressionVariant = expression.replace('?', digit);

      Pattern zeroPattern = Pattern.compile("\\b0\\d");
      Matcher matcher = zeroPattern.matcher(expressionVariant);

      if (expression.contains(Character.toString(digit)) || matcher.find()) {
        continue;
      }

      Pattern pattern = Pattern.compile("(-?[\\d]+)([-*+])(-?[\\d]+)=(-?[\\d]+)");
      matcher = pattern.matcher(expressionVariant);

      matcher.find();

      int number1 = Integer.parseInt(matcher.group(1));
      String operator = matcher.group(2);
      int number2 = Integer.parseInt(matcher.group(3));
      int result = Integer.parseInt(matcher.group(4));

      int intermediateResult;

      switch (operator) {
        case "+":
          intermediateResult = number1 + number2;
          break;
        case "-":
          intermediateResult = number1 - number2;
          break;
        case "*":
          intermediateResult = number1 * number2;
          break;
        default:
          intermediateResult = 0;
          break;
      }

      if (result == intermediateResult) {
        return i;
      }
    }

    return missingDigit;
  }
}
