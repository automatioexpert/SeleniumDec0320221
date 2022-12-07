# DataDrivenFramework-sample

## **Overview:**

Data Driven framework is focused on separating the test scripts logic and the test data from each other. This allows us to create test automation scripts by passing different sets of test data. The test data set is kept in the external files or resources such as MS Excel Sheets, MS Access Tables, SQL Database, XML files etc., The test scripts connect to the external resources to get the test data. This framework significantly reduces the number of test scripts compared to a modular based framework when we need to test for multiple sets of data for same functionality.

For Demo purpose all the test cases are created for [automationpractice.com](http://automationpractice.com/index.php) site.

### **Some of the key features of this framework:**

1. It generates Extent & Allure reports with all the step details.
2. It support parallel execution of test cases.
3. It generates test execution log file.
4. Test execution can be triggered form command line.
5. Easy integration to CI/CD pipeline.
6. Framework uses Page Object Design Pattern, hence there is clean separation between test code and page specific code such as locators and layout.
7. Framework has the capability to re-run the failed test cases.
8. Video recording of test execution can be enabled in local test runs

## **Required Setup :**

- [Java](https://www.guru99.com/install-java.html) should be installed and configured.
- [Maven](https://mkyong.com/maven/how-to-install-maven-in-windows/) should be installed and configured.
- Download the files from Git repository either as zip file OR using [Git](https://phoenixnap.com/kb/how-to-install-git-windows).
- Download and install [Allure](https://github.com/allure-framework/allure-docs/blob/master/docs/getstarted.adoc) commandline application, suitable for your environment.

## **Running Test:**

Open the command prompt and navigate to the folder in which pom.xml file is present.
Run the below Maven command.

    mvn clean test -Dvideo.enabled=false

This will run 2 test cases in parallel (default thread count is 2) and video recording in disabled mode. 
Once the execution completes report will be generated in below folder structure.

**Extent Report:** 	*/test-output/report/test-report.html*

**Allure Report:** To generate the report we need to go through below steps.

To generate the report from existing Allure results use below command.

    allure generate allure-results -c -o allure-report

After the report is generated, open it in default system browser using below command.

    allure open allure-report

**Video Recoding:**

To execute the test cases with [video recording](http://automation-remarks.com/video-recorder-java/) feature run below command.

    mvn clean test -Dvideo.enabled=true -Dparallel.thread=1

###### **Note:**
1. Video recording works well only on local and non parallel execution mode as the video recorder captures the screen.
2. As screen action is been captured by video recorder don't perform any action on screen while test is executing.
