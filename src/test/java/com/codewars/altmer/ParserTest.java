package com.codewars.altmer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class ParserTest {

  @DisplayName("String to number")
  @ParameterizedTest(name = "{0} ==> {1}")
  @CsvSource({
    "zero, 0",
    "one, 1",
    "twenty, 20",
    "two hundred forty-six, 246",
    "thirty-five thousand, 35000",
    "two hundred thousand and three, 200003",
    "seven hundred eighty-three thousand nine hundred and nineteen, 783919",
    "nine hundred thousand two hundred and twelve, 900212",
    "one million, 1000000",
  })
  void parseInt(String string, int number) {
    assertThat(Parser.parseInt(string), is(number));
  }
}
