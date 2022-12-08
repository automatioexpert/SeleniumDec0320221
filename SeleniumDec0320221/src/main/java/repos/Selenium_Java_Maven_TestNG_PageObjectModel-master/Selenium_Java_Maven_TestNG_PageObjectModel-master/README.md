# Selenium_Java_Maven_TestNG
Sample Selenium WebDriver Maven Projects I created in Java by using TestNG and Page Object Model (POM) & Page Factory.

# Setup
## Install Marven and TestNG in Eclipse, and downloaded the selenium chrome webdriver.
You can either google Marven installation in Eclipse, and Install TestNG in Eclipse, or follow the following 3 instructions:
- https://www.youtube.com/watch?v=WzuJANOPLyQ - this is a tutorial for beginners without introducing TestNG nor Maven.
- https://www.techbeamers.com/create-selenium-webdriver-maven-project/
- https://www.guru99.com/maven-jenkins-with-selenium-complete-tutorial.html
## Basically you need to install the following 4 items:
- Java: https://www.guru99.com/install-java.html
- Selenium (including webdrivers): https://www.guru99.com/installing-selenium-webdriver.html
- TestNG: https://www.guru99.com/install-testng-in-eclipse.html
- Maven: https://www.guru99.com/maven-jenkins-with-selenium-complete-tutorial.html

## Create a Maven project 
- From Eclipse - File - New - Other - Maven - Maven Project, Next;
- Check "Create a simple project" and "Use default Workspace location" with absolute path point to \eclipse-space, Next;
- Group Id: com.kugeci, Artifact Id: java-selenium-testng-maven-project, Finish.

## Modify JRE System Library
Right click JRE System Library listed under the newly create Mavan project, properties, select Workspace default JRE, Apply and Close.

## Modify pom.xml
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.kugeci</groupId>
  <artifactId>java-selenium-testng-maven-project</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  
  <properties>
  	<selenium.version>3.9.1</selenium.version>
  	<testng.version>6.14.3</testng.version>
  </properties>
  
 <dependencies>  
 <dependency>
       <groupId>org.seleniumhq.selenium</groupId>
       <artifactId>selenium-java</artifactId>
       <version>${selenium.version}</version>
 </dependency>
 <dependency>
       <groupId>org.testng</groupId>
       <artifactId>testng</artifactId>
       <version>${testng.version}</version>
       <scope>test</scope>
 </dependency>
 </dependencies>
 
</project>
```

## Create TestNG class
- Right click the newly created Maven project, New, Other, TestNG class, Next;
- Source folder \Maven-project-artifact-id\src\test\java, src/main to store developer code, src/test to store testing code;
- Package name: com.kugeci, Class name: HomePageTest, choose @Before Test, and @After Test, Finish.

## Copy WebDriver
- Right click the newly created Maven project, New, Folder, Folder Name: driver, Finish;
- Copy the downloaded Chrome driver, and paste it into Eclipse - newly create Maven project - driver folder (you can paste in Eclipse IDE), and in your code, specify: System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
- Another way to do this is create a "drivers" folder beside your newly created Maven project folder in you folder system, and in the Java code, point to the drivers folder: System.setProperty("webdriver.chrome.driver","..\\drivers\\chromedriver.exe"); 

## Modify TestNG class java file
```java
package com.kugeci;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.chrome.ChromeDriver;		
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class NewlyCreatedTestNGClassName {		
	    private WebDriver driver;		
		@Test				
		public void testEasy() {	
			driver.get("http://demo.guru99.com/test/guru99home/");  
			String title = driver.getTitle();				 
			Assert.assertTrue(title.contains("Demo Guru99 Page")); 		
		}	
	    @BeforeClass
	    public void beforeClass() {
			System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
			driver=new ChromeDriver();
	    }
		@AfterTest
		public void afterTest() {
			driver.quit();			
		}		
}
```

## Convert Maven project to TestNG
Right click on the newly created Maven project, TestNG, Convert to TestNG, a testng.xml will be created below pom.xml, Finish.

## Execute
- Right click on the testng.xml, Run as, TestNG Suite;
- Check results in Console, error massge in Results of running suite, and statistics in Coverate.

# CSS and XPath
- How to write CSS and XPath: https://saucelabs.com/resources/articles/selenium-tips-css-selectors
- Use Ranorex Selocity Chrome plugin to copy paste css and XPath selectors.

# Test Suite and Tests Stucture
- How to structure test classes plese read: http://elementalselenium.com/tips/37-oop;
- TestNG before and after annotations: https://howtodoinjava.com/testng/testng-before-and-after-annotations/

# Debug
- Print variable in Console when executing the scripts: System.out.println(variablename)

# Run Time
- Source code and run time are different, run time are located at "target" folder which is at the same level of "src" folder.
- Normally you change your source code, save it, then run from testng.xml - run as TestNG Suite, the "target" folder will automatically updated to your lateset code.
- However, if you find run time code is not updating after you modified your source code, do the following 2 steps:
- Clean the project (top menu Project - Clean)
- Update the maven project (Project > Maven > Update Maven Project)
