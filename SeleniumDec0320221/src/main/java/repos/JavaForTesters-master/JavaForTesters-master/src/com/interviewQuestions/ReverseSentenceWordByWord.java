/**
 * 
 */
package com.interviewQuestions;

/**
 * Oct 26, 2022
 * 
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
public final class ReverseSentenceWordByWord {

	/**
	 * @author Hassen Oct 26, 2022
	 * @param args
	 */
	public static void main(String[] args) {
		String sentence = "Java Interview Questions";
		String reversedSentence = reverseSentence(sentence);
		System.out.println(reversedSentence);
	}
	
	/**
	 * 
	 * @author Hassen
	 * Oct 26, 2022
	 * @param sentence
	 * @return reverse
	 */

	public static String reverseSentence(String sentence) {
		String reverse = "";
		String[] words = sentence.split("\\s");
		for (int i = words.length - 1; i >= 0; i--) {
			reverse = reverse + words[i] + " ";
		}
		return reverse;
	}

}
