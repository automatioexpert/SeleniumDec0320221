# selenide-basic-example
This project comes to help other new QAs in web automation, bringing examples of how to use Selenide.

#Run all tests
To execute all tests run the command `mvn clean test`

#Generate Allure reports
1. Run the command `mvn test allure:serve` to automatically open the report file after tests execution 

or

2. Run the command `mvn test allure:report` and navigate do directory `target\site\allure-maven-plugin` and open the file `index.html`
