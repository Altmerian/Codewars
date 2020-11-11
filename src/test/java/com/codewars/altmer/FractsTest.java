package com.codewars.altmer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class FractsTest {

	@Test
	public void convertFracTest() {
		long[][] lst = new long[][] { {1, 2}, {1, 3}, {10, 40} };
		String convertedFracts = Fracts.convertFrac(lst);
		assertThat(convertedFracts, is("(6,12)(4,12)(3,12)"));
	}

	@DisplayName("Greatest common divisor")
	@ParameterizedTest(name = "({0}, {1}) ==> {2}")
	@CsvSource({"18, 84, 6", "10, 40, 10", "8, 12, 4", "42, 56, 14"})
	public void findGCDTest(long a, long b, long gcd) {
		long actualGCD = Fracts.findGCD(a, b);
		assertThat(actualGCD, is(gcd));
	}
}