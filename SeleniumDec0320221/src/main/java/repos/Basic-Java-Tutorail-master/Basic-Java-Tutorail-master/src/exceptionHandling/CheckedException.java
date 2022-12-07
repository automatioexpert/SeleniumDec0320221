package exceptionHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CheckedException {
	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("D:/TestFile.txt");
		tryExceptions();
	}

	public static void tryExceptions() {

		try {
			FileInputStream fis = new FileInputStream("D:/TestFile.txt");
		} catch (Exception e) {
			System.out.println("File Not Found");
		}

	}
}
