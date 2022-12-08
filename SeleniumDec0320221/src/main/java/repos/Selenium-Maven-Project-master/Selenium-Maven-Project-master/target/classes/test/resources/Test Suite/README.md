## Automation Test (Task 2 and Task 3) :- Selenium WebDriver-TestNG-Maven Project 
This project is written in Java as a Maven project and will serve an example of implementing a Selenium WebDriver tests with Selenium 3.0 and TestNG

### Steps for Installation and Setup :-
---------------------------------------
* 1.) Java JDK--> Download Java 8 (Recommended) based on your (Windows 10) computer 32 or 64 Bit and set the environment variables below
  -   1.1 JAVA_HOME---> C:\Program Files\Java\jdk1.8.0_121
  -   1.2 PATH     ---> C:\Program Files\Java\jdk1.8.0_121\bin
   you can download from here https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

* 2.) Download and Configure eclipse use Oxygen Eclipse or Eclipse photon,
   You can download Eclipse from here http://www.eclipse.org/downloads/packages/release/oxygen/r/eclipse-ide-java-ee-developers

* 3.) Add the Selenium and TestNG Jar files available from the GitHub https://github.com/JayKishoreDuvvuri/JarFiles to setup. 

   -   3.1 You can also download TestNG and Selenium Jar files from your own sources. However, you can download from here as well!
   
   -   3.2 Ensure TestNG is installed in your Eclipse.If not installed, For installation goto Eclipse-->Help-->Eclipse Market place,                Search in the Search box for TestNG, type TestNG in search box and click search button. You will get 'TestNG for Eclipse'.              Now click on the Install button and Install TestNG in your Eclipse.
   
   -   3.3 For TestNG Jar files, goto http://testng.org/doc/download.html and download from here (OR) goto Maven Repository                        https://mvnrepository.com/artifact/org.testng/testng/6.14.3 and download jar from here. You can also download from the                  GitHub https://github.com/JayKishoreDuvvuri/JarFiles. Now in your Eclipse, Navigate to Properties-->BuildPath-->Add External            Jars and add the Jars. you are now ready to proceed with TestNG in your Eclipse. Add the TestNG Library.
   
   -   3.4 For selenium Jar files you can download from https://www.seleniumhq.org/download/  (OR)  from the GitHub link                            https://github.com/JayKishoreDuvvuri/JarFiles. In this link you have a folder called 'Referenced Libraries' you can get all              the Selenium Jar files from here as well and 'TestNG folder' have the TestNG Jar files 
   
   -   3.5  Ensure JRE System Library is set to JavaSE-1.8(JDK 1.8)
   
   -   3.6  Ensure Maven Dependencies are added.



* 4.) In Eclipse, Click on the 'Projects' Tab and select 'Properties'. Hover to Java Build Path. Here click 'Add External Jars' button        and add Jars accordingly. Click 'Apply and close'.
  
  
  
* 5.) Download the Automation Project from GitHub https://github.com/JayKishoreDuvvuri/AutomationTest and save it to your computers            Desktop or shared drive. Rename the folder name from "AutomationTest-master" to "AutomationTest". Now Import this project into          your eclipse as a Maven project. The New Project is with Name 'BonifyAutomation'. Please check.

    -  5.1 In Eclipse goto 'help'-->'Eclipse market place and type 'MAVEN' in 'Find to' search box. You will find as 'M2e' click and                install it. 
    -  5.2 If already Maven is installed in your system, please ignore the step 5.1.




* 6.) Open your Eclipse and hover to the tab 'File' at the Left top corner in Eclipse. Select "Import" option. Now, Under Maven folder,       select 'Existing Maven Project' and click 'Next'. Select the directory i.e. desktop where you downloaded your project from GitHub.

   -  6.1 Now Click the check box for (pom) and add the project.Now click on 'Finish' Button and the project is imported into your                 eclipse.
   
   -  6.2 Available folders in the project are src/main/java please ignore this folder! you have folder 'src/test/java' - you have 2               test cases in this folder under the package com.bonify.QA.Testcases. The two test cases are 'LoginPageTest.java' and                     'IFrameTest.java'.
   
   - 6.3 You have 'src/test/resources' folder which contains a folder 'Test Suite', In this folder you have the geckodriver.exe,                  chromedriver.exe for test execution and a TestNG.xml file
   
   - 6.4 Open the 'TestNG.xml' file in Eclipse, The tests are ran by me successfully in Firefox browser. You can see comments for chrome          browser in this 'TestNG.xml' file. If you want to execute tests in the Chrome browser then comment the line for firefox browser          and uncomment chrome browser in the file as shown below step 6.5
   
   - 6.5 parameter name="browser" value="Chrome"
         (Chrome browser is commented and if you want to run tests in chrome uncomment by removing '<!--' and '-->' in above line)
	 
   - 6.6 parameter name="browser" value="Firefox"
         (This line in TESTNG.xml file is uncommented and ready to run the tests in Firefox Browser)
	 
	 

7.)  Ensure your project 'AutomationTest/BonifyAutomation' is loaded with all the necessary Libraries. 
     The Libraries are JRE System Library[JavaSE-1.8], Referenced Libraries having all Selenium Jar files and TestNG Library, Maven          Dependencies. Please see the screenshot with name ‘Project Structure in Eclipse - Maven Project’ it shows the structure of the          Maven project in Eclipse and all necessary Libraries.
    
    
8.)  Once adding all Jar files and libraries, Right click on your project folder and Goto --> Maven-->'Update Project' just to clear any     errors if occur. This is mandatory.

   
### Test cases created for 'BonifyAutomation' Project in Selenium WebDriver:-
-----------------------------------------------------------------------------
* Check for the test cases in your project with name BonifyAutomation--->src/test/java---->com.bonify.QA.Testcases---->2 Test cases
  
* Folder src/test/resources---> Have a folder 'Test Suite', Folder 'Test Suite' --> Contain 'chromedriver.exe', 'geckodriver.exe' and 'TestNG.xml'   file
  
* Folder 'src/test/java' have two Test cases in the package 'com.bonify.QA.Testcases' designed are with the names below
  - LoginPageTest.java
  - IFrameTest.java
  

### Steps to Run the Test Cases in Selenium WebDriver/TestNG:-
--------------------------------------------------------------
* 1.) LoginPageTest.java -

  -    Pre-Requisites: Java JDK(Java System Library[JavaSE-1.8], TestNG, Referenced Libraries, Maven with Maven Dependencies installed          in Eclipse IDE.
  
  
  *    Scenario Tested are menioned below: All the links present on the page. 
 
  -	   1.1 Forgot Password and Checking Back Button
  
  -	   1.2 Validation of Impressum link, AGB - Conditions link and Datenschutz - Data Protection Link.
  
  -	   1.4 SignUp OR Register as a New User for creating a new account
  
  -	   1.5 Login to Application as an Already Existing User
  
  
  
 
* 2.) IFrameTest.java -

  -    Pre-Requisites: Pre-Requisites: Java JDK(Java System Library[JavaSE-1.8], TestNG, Referenced Libraries, Maven with Maven                Dependencies installed in Eclipse IDE.
  
  *   Scenario Tested are mentioned below: FINANZEN Tab - Kreditkarten - using IFrame.
        
  -	   2.1 Enter the data in the text boxes and Select data from drop downs
  
  -	   2.2 Click Submit to Retrieve the item list to select a particular item
  
  -	   2.3 Click the item from the list and navigate to a new window (Product's Website) to view the product information
  
  
  
  *    Scenario Tested are mentioned below: MOBILFUNK Tab - using IFrame.
        
	
  -	   2.4 Enter the data by selecting various dropdown's on the page and to retrieve the price/provider list by clicking submit 
               button(Tarife) for stores/items prices related to the mobile phone
	       
  -	   2.5 From the list displayed on the page, Select the required provider by clicking 'zum Anbieter' button
  
  -	   2.6 The page is navigated to a new window with the provider information. 
  
 
 
 
 
* 3.) Run the Tests in Selenium WebDriver/Maven: -   
      
  -	Open the 'pom.xml' file present in the bottom of the project in Eclipse IDE
  
  -	   3.1 Goto 'Run' tab of Eclipse at the top and click on it. 
  
  -	   3.2 Now Select, Run As--> Maven install 
  
  -	   3.3 Once the Build is Success, check the output on the console window.
  
  -	   3.4 if you want to clean and start as fresh do Run As - Maven clean but not necessary
  
  -	   3.5 Maven install/Maven test commands will execute the test cases in Maven and finally you get BUILD SUCCESS! or if any                      errors exist will display the errors too!
  
  -	   3.6 Tests Passed and failed are displayed at the end of process in the ouput
  
  -	   3.7 In our case Total Test cases are 6 and all were passed with '0' Failures
  
  -	   3.8 You can view the reports as 'Extent Reports' (OR) you can view the reports from the 'test-output' folder named as                        'emailable-report.html' and 'index.html'
  
  -	   3.9 You can also view the reports from the folders 'target'--->'surefire-reports'--->'emailable-report.html'(OR) index.html                           
  -	   3.10 In My case the the two tests LoginPageTest and IFrameTest which both have a total '6' tests ran successfully with no                     failures and all tests are passed with count as Passed - 6, Fail - 0, Skip - 0.
	       
  -	   3.11 The BonifyAutomation-0.0.1-SNAPSHOT.jar is available in the 'target' folder.
	       
 
  
  
             
  
  
  
  
  
* 4.) Run the Tests in Selenium/TestNG: -  
     
  -	Open the TestNG.xml file present in the structure "BonifyAutomation-->src/test/resources--->Test Suite---> TestNg.xml"
  
  -	   4.1 Goto 'Run' and click Run
  -	   4.2 Select Run As-->TestNG Suite
  -	   4.3 Tests are executed successfully with '0' failures. Total tests are passed is : '6'      
  -	   4.4 To view Test Reports of the tests ran you can go to the test-output folder and open it.
  -	   4.5 You can see emailable-report.html and index.html for the reports generated.
  -	   4.6 To see the Reports right click on the index html 'OR' emailable report html and open with--> Web Browser


 
	   
* 5.) The tests were ran successfully in Firefox from my end. You can execute the same tests in Firefox without changing                       anything in the 'TestNg.xml' file or 'pom.xml' file. If you want to execute the tests in Chrome then comment the line for Firefox       and uncomment the line for chrome in 'TestNG.xml' file.

Thank You!
	
	   
	   
	
