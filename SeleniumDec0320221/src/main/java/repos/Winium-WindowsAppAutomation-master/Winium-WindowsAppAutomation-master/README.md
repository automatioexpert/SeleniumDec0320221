# Winium-WindowsAppAutomation

This is a Winium+Maven+TestNG based framework to automate basic tasks of windows calculator. As a scope of this project, I have automated only addition, modulus, division and square root operations. However framework is capable of performing all operations with all modes of calculator like Scientific, Programmer, etc. with minimum modification/addition in code.

0. [System Requirement](#system-requirement)
1. [Steps to Import Project](#steps-to-import-project)
2. [How to Run?](#how-to-run?)
3. [Out of Scope](#out-of-scope)

 

### System Requirement:

1. Windows 10 System with inbuilt Calculator application
2. Eclipse with maven extension
3. Java

 

### Steps to import project:

1. Unzip the donwloaded file
2. In Eclipse, navigate to Fileà Importà Mavenà Existing Maven Projects, Click Next and select the unzipped folder in Root directory
3. Select pom.xml in Projects section on Maven Project screen and click on Finish
4. Project should get added in Workspace

 
### How to Run?
 
1. Go to Driver folder in unzipped folder and run Winium.Desktop.Driver.exeà Starting Windows Desktop Driver on port 9999 message should be displayed
2. Navigate to com.calculatorautomation.config package and open config.properties file
3. Provide calculator application path for ‘CalculatorPath’ key. Current given path is correct in most of the cases however once check if calc.exe is present at given location else change it to correct path
4. Now go to project in Workspace and open testing.xml
5. Here in Parameter tag you can provide the desired expression as a value which you want to perform on calculator application
6. In AppTest.java file under src/test/java Calculator_Winium.Calculator_Winium package, Test methods are written to verify the functionality
7. In Assert statement in each Test method, provide expected result for each expression
8. 
 a. Run using maven
 
              i.   Right click on project and choose Run As-> Maven Clean
              ii.  Right click on project and choose Run As-> Maven test
              iii. Execution will start and desired operation will be performed on calculator
              iv.  Execution report will be available at target/surefire-reports/emailable-report.html
              
   b. Run using TestNG
   
              i.   Open testng.xml
              ii.  Run xml and execution will start and desired operation will be performed on calculator
              iii. Execution report will be generated at test-output/emailable-report.html

 
### Out of scope:

1. I haven’t handled the check on provided expression as a input. So please provide input values in given format only
2. In any case if calculator doesn’t appear on top, click on calculator icon in taskbar immediately and if any test fails, please rerun the tests


