package com.calculatorautomation.ObjectRepo;

import com.calculatorautomation.base.TestBase;

public class CalculationsByCalculator extends TestBase {
	/**
	 * @author Krishna Majgaonkar
	 * 
	 */

	ObjectRepository repo = new ObjectRepository();

	public String additon(String expression) {
		char[] ar = expression.toCharArray();
		for (int i = 0; i < ar.length; i++) {
			if (String.valueOf(ar[i]).equals("+")) {
				repo.chooseOption("Plus").click();
			} else if (String.valueOf(ar[i]).equals(".")) {
				repo.chooseOption("Decimal Seperator").click();
			} else
				repo.chooseNumber(Integer.parseInt(String.valueOf(ar[i]))).click();
		}
		repo.chooseOption("Equals").click();
		return getFormattedResult(repo.chooseOptionByID("CalculatorResults").getAttribute("Name"));
	}

	public String division(String expression) {
		char[] ar = expression.toCharArray();
		for (int i = 0; i < ar.length; i++) {
			if (String.valueOf(ar[i]).equals("/")) {
				repo.chooseOption("Divide by").click();
			} else if (String.valueOf(ar[i]).equals(".")) {
				repo.chooseOption("Decimal Seperator").click();
			} else
				repo.chooseNumber(Integer.parseInt(String.valueOf(ar[i]))).click();
		}
		repo.chooseOption("Equals").click();
		return getFormattedResult(repo.chooseOptionByID("CalculatorResults").getAttribute("Name"));
	}

	public String mod(String expression) {
		char[] ar = expression.toCharArray();
		for (int i = 0; i < ar.length; i++) {
			if (String.valueOf(ar[i]).equals("|")) {
				repo.chooseOption("Modulo").click();
			} else if (String.valueOf(ar[i]).equals(".")) {
				repo.chooseOption("Decimal Seperator").click();
			} else
				repo.chooseNumber(Integer.parseInt(String.valueOf(ar[i]))).click();
		}
		repo.chooseOption("Equals").click();
		return getFormattedResult(repo.chooseOptionByID("CalculatorResults").getAttribute("Name"));
	}

	public String sqr(String expression) {
		char[] ar = expression.toCharArray();
		for (int i = 0; i < ar.length; i++) {
			repo.chooseNumber(Integer.parseInt(String.valueOf(ar[i]))).click();
		}
		for (int j = 0; j < 3; j++) {
			repo.chooseOption("Square root").click();
		}
		repo.chooseOption("Equals").click();
		return  getFormattedResult(repo.chooseOptionByID("CalculatorResults").getAttribute("Name"));
	}

	private String getFormattedResult(String result) {
		String[] str = result.split(" ");
		return str[str.length - 1];
	}
}
