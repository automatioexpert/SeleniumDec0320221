package practice_Java_2;

import java.util.Scanner;

public class Operator {

	public static void main(String[] args) {
		double num1, num2, output;

		System.out.println("Please enter the first number: ");

		Scanner input = new Scanner(System.in);
		num1 = input.nextDouble();

		System.out.println("Please enter the first number: ");
		num2 = input.nextDouble();

		System.out.print("Enter an operator (+, -, *, /): ");

		char operator = input.next().charAt(0);

		switch (operator) {
		case '+':
			output = num1 + num2;
			break;
		case '-':
			output = num1 - num2;
			break;

		case '*':
			output = num1 * num2;
			break;

		case '/':
			output = num1 / num2;
			break;

		/*
		 * If user enters any other operator or char apart from +, -, * and /, then
		 * display an error message to user
		 * 
		 */
		default:
			System.out.printf("You have entered wrong operator");
			return;
		}
		System.out.println(+num1 + " " + operator + " " + num2 + " is: " + output);
	}
}
