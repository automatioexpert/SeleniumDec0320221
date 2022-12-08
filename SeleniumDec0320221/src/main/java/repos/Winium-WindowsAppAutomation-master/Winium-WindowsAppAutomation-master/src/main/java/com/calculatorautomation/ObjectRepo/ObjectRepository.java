package com.calculatorautomation.ObjectRepo;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.calculatorautomation.base.TestBase;

public class ObjectRepository extends TestBase {
	/**
	 * @author Krishna Majgaonkar
	 * This class contains logic to find elements of calculator application
	 * Elements are identified based on their properties (e.g. Name, Id)
	 * 
	 */

	protected HashMap<Integer, String> numberRepo = null;
	WebElement element = null;

	public ObjectRepository() {
		numberRepo = new HashMap<Integer, String>();
		numberRepo.put(1, "One");
		numberRepo.put(2, "Two");
		numberRepo.put(3, "Three");
		numberRepo.put(4, "Four");
		numberRepo.put(5, "Five");
		numberRepo.put(6, "Six");
		numberRepo.put(7, "Seven");
		numberRepo.put(8, "Eight");
		numberRepo.put(9, "Nine");
		numberRepo.put(0, "Zero");
	}

	public WebElement chooseNumber(int number) {
		try {
			element = driver.findElement(By.name(numberRepo.get(number)));
		} catch (NoSuchElementException e) {
			System.out.println("No element present");
		}
		return element;
	}

	public WebElement chooseOption(String option) {
		try {
			element = driver.findElement(By.name(option));

		} catch (NoSuchElementException e) {
			System.out.println("No element present");
		}
		return element;
	}

	public WebElement chooseOptionByID(String option) {
		try {
			element = driver.findElement(By.id(option));
		} catch (NoSuchElementException e) {
			System.out.println("No element present");
		}
		return element;
	}

}
