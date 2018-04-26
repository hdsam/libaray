package com.ygy.action;

public class Function {

	public static String JumpTo(String alertMessage, String jumpTo) {
		String str = null;
		if (alertMessage == null || alertMessage.length() == 0) {
			str = "<script language='javascript'>location.href='" + jumpTo + "';</script>";
		} else {
			str = "<script language='javascript'>alert('" + alertMessage + "');location.href='" + jumpTo
					+ "';</script>";
		}
		return str;
	}

	public static int strToInt(String str) {
		int a = 0;
		try {
			a = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			a = 0;
		}
		return a;
	}

}
