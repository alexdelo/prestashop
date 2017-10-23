package com.automation.prestashop;

import java.util.Random;

public class GenerateRandomString {

	static Random random = new Random();

	public static String randomString(int length) {
		final String data = "abcdefghijklmnoprstuwyzx";

		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++)
			sb.append(data.charAt(random.nextInt(data.length())));

		return sb.toString();
	}

	public static String randomEmail() {

		int length = 10;
		String name = "0123456789abcdefghijklmnoprstuwyzx";
		String firstDomain = "email";
		String secondDomain = "com";

		String email = new String();

		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++)
			sb.append(name.charAt(random.nextInt(name.length())));
		email += sb;

		/*sb = new StringBuilder(length);
		for (int i = 0; i < length; i++)
			sb.append(firstDomain.charAt(random.nextInt(firstDomain.length())));*/
		email += "@" + firstDomain;

		/*sb = new StringBuilder(length);
		for (int i = 0; i < length; i++)
			sb.append(secondDomain.charAt(random.nextInt(secondDomain.length())));*/
		email += "." + secondDomain;

		return email;
	}

	public static String randomNumber(int length) {
		final String numbers = "23456789";
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++)
			sb.append(numbers.charAt(random.nextInt(numbers.length())));

		return sb.toString();
	}
	
	
}
