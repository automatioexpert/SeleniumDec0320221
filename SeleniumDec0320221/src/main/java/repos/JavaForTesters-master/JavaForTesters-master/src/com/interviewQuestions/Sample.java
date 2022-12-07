/**
 * 
 */
package com.interviewQuestions;

/**
 * Oct 14, 2022
 * 
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
public final class Sample {
	public static void main(String[] args) {
		if (args.length > 0) {
			System.out.println("The command line" + " arguments are:");
			for (String val : args)
				System.out.println(val);
		} else
			System.out.println("No command line " + "arguments found.");
	}
}
