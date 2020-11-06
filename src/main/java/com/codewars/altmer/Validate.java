package com.codewars.altmer;

public class Validate {
	public static boolean validate(String n) {
		boolean otherDigit = false;
		int sum = 0;
		for (int i = n.length() - 1; i >= 0; i--) {
	    int digit = Character.getNumericValue(n.charAt(i));
			sum += (otherDigit ) ? doubleOrReplace(digit) : digit;
			otherDigit ^= true;
    }
		return sum % 10 == 0;
	}

	static int doubleOrReplace(int digit) {
		digit *=2;
		return (digit > 9) ? digit - 9 : digit;
	}
}
