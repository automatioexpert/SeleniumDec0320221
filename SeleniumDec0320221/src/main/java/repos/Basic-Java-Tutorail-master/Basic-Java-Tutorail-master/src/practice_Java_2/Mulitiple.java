package practice_Java_2;

import java.util.Scanner;

public class Mulitiple {

	public static void main(String[] args) {
		PrintMulipile();
	}
	public static void PrintMulipile() {
		Scanner input= new Scanner(System.in);
		System.out.print("Please enter the number:");
		int n = input.nextInt();
		  for (int i = 0; i <= 10; i++) {
			System.out.println(n + "*" +i +"=" +(n*i));
		   }
	 }
}
