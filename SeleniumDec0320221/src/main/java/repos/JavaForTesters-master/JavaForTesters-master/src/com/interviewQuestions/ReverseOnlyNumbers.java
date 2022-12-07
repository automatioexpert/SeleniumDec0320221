/**
 * 
 */
package com.interviewQuestions;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Oct 31, 2022
 * 
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
public final class ReverseOnlyNumbers {

	public static void main(String[] args) {
		String input = "test12pop90java978pyt";
		Matcher m = Pattern.compile("\\d+").matcher(input);
		while (m.find())
			input = input.replace(m.group(), new StringBuilder(m.group()).reverse());
		System.out.println(input);
	}
}
