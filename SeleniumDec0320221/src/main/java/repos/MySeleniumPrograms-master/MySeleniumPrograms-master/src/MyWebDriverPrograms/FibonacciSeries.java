package MyWebDriverPrograms;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args)
    {
        int original, a = 0, b = 0, c = 1;
        Scanner inputvalue = new Scanner(System.in);
        System.out.println("Enter Inputvalue :");
        original = inputvalue.nextInt();
        System.out.print("Fibonacci Series : ");
        for(int i = 1; i <= original; i++)
        {
            a = b;
            b = c;
            c = a + b;
            System.out.print(a+" ");
        }
        inputvalue.close();
    }
}