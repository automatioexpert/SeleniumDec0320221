/**
 * 
 */
package com.interviewQuestions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Oct 31, 2022
 * @author HASSEN
 * @version 1.0
 * @since 1.0
 */
public final class StringWordCount {

	/**
	 * @author Hassen
	 * Oct 31, 2022
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "rrrffagggg";
		List<String> charList = new ArrayList<>();
        for (char ch : input.toCharArray()) {
        	charList.add(String.valueOf(ch));
        }
        System.out.println(charList);
        
        Map<Character, Long> charFrequency = charList.stream() 
        		.flatMap(a -> a.chars().mapToObj(c -> (char) c)) 
		        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		charFrequency.forEach((k,v) -> System.out.print(v+""+k));
		
		
		System.out.println();
		
		//
		String s = "rrrffagggg";//3r2ff1a4gg
		Map<Character, Integer> charSeq = new LinkedHashMap<>();
		for (char c : s.toCharArray()) {
			charSeq.merge(c,1,Integer::sum);      
		}
		charSeq.forEach((k,v) -> System.out.print(v+""+k));
		System.out.println();
		
		System.out.println(0.1+0.2);
		System.out.println(0.1+0.4);
		System.out.println(0.0/0.0);
		System.out.println(9.0/0.0);
		System.out.println(9/0);
	}
}
