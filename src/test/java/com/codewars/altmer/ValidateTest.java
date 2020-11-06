package com.codewars.altmer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class ValidateTest {

	@DisplayName("Is this a valid credit card number?")
	@ParameterizedTest(name = "{0} ==> {1}")
	@CsvSource({"919, true","326967, true", "10110921722, true"})
	void validatePositiveTest(String number, Boolean expected) {
		assertThat(Validate.validate(number), is(expected));
	}

	@DisplayName("Is this an invalid credit card number?")
	@ParameterizedTest(name = "{0} ==> {1}")
	@CsvSource({"891, false", "326968, false", "10110921723, false"})
	void validateNegativeTest(String number, Boolean expected) {
		assertThat(Validate.validate(number), is(expected));
	}

	@ParameterizedTest(name = "{0} ==> {1}")
	@CsvSource({"3, 6", "8, 7", "0, 0", "9, 9"})
  void doubleOrReplacePositiveTest(int digit, int expected) {
		assertThat(Validate.doubleOrReplace(digit), is(expected));
  }
}