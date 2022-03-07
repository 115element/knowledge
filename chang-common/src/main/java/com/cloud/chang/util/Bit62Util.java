package com.cloud.chang.util;

import java.math.BigInteger;
import java.util.Stack;

public class Bit62Util {

	private static String digths = "52bk8eRstHu4CAIPJ7fSqwF3B1Qh0LWlngNVpU9GcTvamirEdxY6MZODXzojyK";

	public static String _10To62(BigInteger num) {
		BigInteger zero = new BigInteger("0");
		BigInteger _62 = new BigInteger("62");

		Stack<Character> stack = new Stack<Character>();

		while (num.compareTo(zero) != 0) {
			int index = num.remainder(_62).intValue();
			stack.push(digths.charAt(index));
			num = num.divide(_62);
		}

		String newstr = "";
		while (!stack.isEmpty()) {
			newstr += stack.pop();
		}

		return newstr;
	}

	public static String _62To10(String c) {
		if (c == null || c.isEmpty()) {
			return "-1";
		}
		if (!c.matches("[0-9a-zA-Z]+")) {
			return "-1";
		}
		char[] charArr = c.toCharArray();
		BigInteger bigIntValue = new BigInteger("0");
		BigInteger _62 = new BigInteger("62");
		for (int i = 0; i < charArr.length; i++) {
			int index = digths.indexOf(charArr[i]);
			int v = charArr.length - i - 1;
			BigInteger val = _62.pow(v).multiply(new BigInteger(index + ""));
			bigIntValue = bigIntValue.add(val);
		}
		return bigIntValue.toString();
	}

}
