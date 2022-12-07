# How to run the Test #

**Prerequisite**
1. Java environment 
2. Maven 
3. JUnit


**Note: Configure web-driver path and pom.xml file.**

- Configure webdriver.
    - I used ChromeDriver but you can choose other webdriver eg. Mozilla GeckoDriver. I have written code for GeckoDriver also. 
    - First download ChromeDriver from [http://chromedriver.chromium.org/downloads](http://chromedriver.chromium.org/downloads).
    - Copy your downloaded **chromedriver.exe** file path.
    - Go to **GreenKartPractice\src\main\java\resources\Base.java** file.
    - Paste the copied driver file path in `System.setProperty("webdriver.chrome.driver","Paste chrome driver path here")` or `System.setProperty("webdriver.gecko.driver","Paste gecko driver path here")`.
    
	
- Configure pom.xml.
    - I have written all the maven dependencies in **pom.xml** file. So if your are running this project after a long time, then please update all the dependencies with current version in this file.   
    - Update your Cucumber-Java and Cucumber-JUnit dependencies from this link: [https://mvnrepository.com/artifact/io.cucumber](https://mvnrepository.com/artifact/io.cucumber).
    - Update your Selenium-Java dependencies from this link: [https://mvnrepository.com/artifact/org.seleniumhq.selenium](https://mvnrepository.com/artifact/org.seleniumhq.selenium).
    

    
Project is ready to run. Execute following commands and enjoy the automatic web-driver test.
- Open this project in your IDE.
- Select **GreenKartPractice\src\test\java\cucumberOptions\TestRunner.java** file 
- Run as **JUnit Test**

You can find the test result in **GreenKartPractice\target\cucumber.html**.