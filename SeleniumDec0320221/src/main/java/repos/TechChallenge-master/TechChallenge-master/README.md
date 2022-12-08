# TechChallenge

Prerequistes to be installed in machine:
---------------------------------
1) Java/JDK (My machine java version: 1.8.0_201)
2) Apache Maven (My machine Maven version 3.6.0)
3) OS (I developed the project on windows)
4) Java JDK and Maven enviroment variables location updated in system variables path 

To BUILD and RUN the PROJECT:
-----------------------------
1) Using Java ECLIPSE (or any IDE):
- Import the project as Maven project from GitHub
- Update the project by right click project and select Maven Update Project
- Resolve any build error(if present)
- If TestNg available in Eclipse then right click src/test/java/resources/uatTests.xml and Run as TestNg Suite
- If TestNg not available in Eclipse then Run as Maven project. Right click project and Run As Maven clean Maven Install
- Follow below steps for error "No compiler is provided in this environment. Perhaps you are running on a JRE rather than a JDK?"
	- In Eclipse, Windows > Click on preferences
	- Click on Java > Installed JRE’s
	- Here you will get JRE now we need to change it to JDK
	- Add JDK > Click on Add > Select Standard VM
	- Browse JDK by where it is located. Generally it is in C:\Program Files\Java\jdk1.8.0_181
	- Click Finish, Select JDK, Apply, ok
	- Right click Project > Build Path > Configure Build Path > Libraries > Select JRE System Library > Edit > Select Execution Env jdk > Finish > Apply > OK
	- Right pom.xml file Run As Maven clean then Maven Install 

2) Using COMMAND prompt:
- Clone the entire project to your local machine repository
- Open Command Prompt, and go the project folder
- type mvn install and enter
- eg C:\LocalFolder\TechChallenge>mvn test

3) Using CI tool like JENKINS
- Install Jenkins if not available
- Jenkins -> Manage Jenkins -> Configure System
 	- Go to Extended E-mail Notification section
	- SMTP server: enter mailhost
	- Default content: HTML
	- Default Recipients: Add your email
	- Reply To List	: Add your email
  - Apply Save
- Click New Item and Create New Maven Project
- Go the Project -> Configure
- In Source Code Management Section select Git
	- Enter the project GIT Hub Repository URL https://github.com/anandacharya/TechChallenge.git
	- Branch to build */master
- In Build Section
 	- Root POM: $workspace\pom.xml
	- Goals and options: clean test
- In Post-Build Actions section
 	- TestNG XML report pattern: **/testng-results.xml
	- Editable Email Notification
		- Project From: enter your email id
		- Project Recipient List: enter your email id
		- Content Type HTML (text/xml)
		- Default Subject: Test Summary report
		- Default Content: ${FILE,path="target/surefire-reports/emailable-report.html"}
- Click Apply Save
- Click Build and verify that the test cases are executed

About the AUTOMATION framework:
------------------------------
The automation framework is developed using concepts of Page Object Model with Page Factory design pattern, data driven framework, and TDD framework (TestNg). Java is the binding language. The source code is available in the SRC folder. 
Below are highlights of the framework.
1) Each web page represented as class file where the page web elements and actions on the web elements are defined
2) Allows code reuse to add new test scenarios without major changes to the framework
3) Allows parallel cross browser execution
4) Auto events logging on every action performed on the web element
5) Capturing failed tests screenshots
6) Auto re-run of test cases in case of failure
7) Test summary report generation
8) Flexibility to run from CI tool like Jenkins

DEMO video:
----------
Below video shows the parallel automated execution of a single test case on both chrome and firefox browser 
https://drive.google.com/open?id=187RwhCGvsUHUS9SNnTd6CMMqrGmsp9iG
