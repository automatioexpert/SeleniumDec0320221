### Automation Pages Cover
- login page
- Registration page
- Choose product from menu
- Select product
- Apply Add to cart
- Complete Add steps for checkout 
 
### Project Details
- Create a maven project
  - File -> New -> Maven project -> Set workspace -> maven quick start -> add group id and artifact id
- Right Click on project(build path)
  - go build path -> configuration build path -> click add library -> click excution enviroment -> java se 11(or what ever you use) or default enviroment -> apply -> ok
- pom file setup -> go to maven repository then copy this pom packages
  - selenium-java
  - webdrivermanager
  - testng
```
  <dependencies>
        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>4.3.0</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.testng/testng -->
		<dependency>
			<groupId>org.testng</groupId>
			<artifactId>testng</artifactId>
			<version>7.6.1</version>
			<scope>test</scope>
		</dependency>

		<!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
		<dependency>
			<groupId>io.github.bonigarcia</groupId>
			<artifactId>webdrivermanager</artifactId>
			<version>5.2.3</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
		<dependency>
			<groupId>com.aventstack</groupId>
			<artifactId>extentreports</artifactId>
			<version>5.0.9</version>
		</dependency>

		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>3.8.1</version>
			<scope>test</scope>
		</dependency>

		<!-- https://mvnrepository.com/artifact/com.github.javafaker/javafaker -->
		<dependency>
			<groupId>com.github.javafaker</groupId>
			<artifactId>javafaker</artifactId>
			<version>1.0.2</version>
		</dependency>

		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>htmlunit-driver</artifactId>
			<version>2.62.0</version>
		</dependency>


		<!-- https://mvnrepository.com/artifact/log4j/log4j -->
		<dependency>
			<groupId>log4j</groupId>
			<artifactId>log4j</artifactId>
			<version>1.2.17</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.slf4j/slf4j-log4j12 -->
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-log4j12</artifactId>
			<version>1.7.36</version>
			<type>pom</type>
			<scope>test</scope>
		</dependency>
  </dependencies>
```
### Dependency Details
- extentreports
  - for report generate
- javafaker
  - random value generate 

### Description

- BaseDriver
- Page -> Page class -> Location and Methods
- Test -> Test case class-> Called Only Methods(Page class)
- Utilities -> common method

  
 
