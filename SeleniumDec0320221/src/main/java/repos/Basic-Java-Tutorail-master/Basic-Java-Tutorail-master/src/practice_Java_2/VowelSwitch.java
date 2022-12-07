package practice_Java_2;

import java.util.Scanner;

public class VowelSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean isVowel = false;

		System.out.println("Enter a character :");
		Scanner input = new Scanner(System.in);

		char ch = input.next().charAt(0);
		switch (ch) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
		case 'A':
		case 'E':
		case 'I':
		case 'O':
		case 'U':isVowel = true;
		}

		if (isVowel == true) {
			System.out.println(ch+ " is a vowel");
		} else {
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
				System.out.println(ch+ " is a consonant");
			else
				System.out.println("Input is not an alphabet");
		}

	}
}