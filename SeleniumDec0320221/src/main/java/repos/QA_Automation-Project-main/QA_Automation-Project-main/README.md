# SQA-Project
Selenium, TestNG, Maven, Cucumber, and using existing chrome selenium for login solution


#How To Execute Selenium Scripts On Already Opened Browser.


Step 1- Start Chrome in debug mode

      Navigate to chrome directory using the cd command
      In my case chrome.exe is under C:\Program Files (x86)\Google\Chrome\Application
    ==> cd C:\Program Files (x86)\Google\Chrome\Application

      Syntax
      chrome.exe –remote-debugging-port=any-free-port –user-data-dir=directory (path where you need to store data)

      Example in my case
    ==>  chrome.exe --remote-debugging-port=9222 --user-data-dir=C:\chromeData

Step 2- Execute Selenium test on port 9222

      // set the driver path- You can also use WebDriverManager for drivers
      System.setProperty("webdriver.chrome.driver","your chrome driver");

      // Create object of ChromeOptions Class
      ChromeOptions opt=new ChromeOptions();

      // pass the debuggerAddress and pass the port along with host. Since I am running test on local so using localhost
      opt.setExperimentalOption("debuggerAddress","localhost:9222 ");

      // pass ChromeOptions object to ChromeDriver constructor
      WebDriver driver=new ChromeDriver(opt);

      // now you can use now existing Browser
      driver.get(targetURL); ==>type the URL what you want to browse
      
      
      
      
#HOW TO OPEN EXCEL (.xlsx) using maven

Maven dependency
https://www.java67.com/2014/09/how-to-read-write-xlsx-file-in-java-apache-poi-example.html

                  <!--       
                        <dependency>
                            <groupId>org.apache.poi</groupId>
                            <artifactId>poi</artifactId>
                            <version>5.2.0</version>
                        </dependency>
                        <dependency>
                            <groupId>org.apache.poi</groupId>
                            <artifactId>poi-ooxml</artifactId>
                            <version>5.2.0</version>
                        </dependency>
                   -->

Library

      import org.apache.poi.ss.usermodel.Cell;
      import org.apache.poi.ss.usermodel.Row;
      import org.apache.poi.ss.usermodel.Sheet;
      import org.apache.poi.ss.usermodel.Workbook;
      import org.apache.poi.xssf.usermodel.XSSFRow;
      import org.apache.poi.xssf.usermodel.XSSFSheet;
      import org.apache.poi.xssf.usermodel.XSSFWorkbook;

      import java.io.File;
      import java.io.FileInputStream;
      import java.io.IOException;
      import java.util.Iterator;




# Architecture Testing

#Singleton Design Pattern.


The Singleton pattern encapsulates a shared resource within a single unique class instance.
This instance arbitrates access to the resource and storage-related state information.
A class method provides the reference to this instance, so there is no need to pass the reference around.
Any object that has access to the Singleton’s class header can use the Singleton.



![alt text](https://miro.medium.com/max/1400/1*PU3WlRgmmIBPsW1L_2S2MQ.png)
https://miro.medium.com/max/1400/1*PU3WlRgmmIBPsW1L_2S2MQ.png

The Singleton Design Pattern can be used in the automation tests to build up easier access to page objects and facades.
Its usage can speed up the tests writing process dramatically.

I’ve covered the basic mechanics of the Singleton pattern, but why should we use it? Isn’t this just making our code more verbose and confusing? And what does all of this have to do with testing anyway?!

We should only apply patterns when we really need them, not just because some writer on the internet tells you to use it.

In the case of testing, here are some problems we may encounter:

1. Our classes and their dependencies can get very complex, and we don’t want to do end-to-end testing for every class, especially controllers.
2. We can’t always test at specific dates or times. What about bugs that happen only on the last day of the month, or 11:59PM GMT?
3. We can’t (or don’t want to) create specific data, such as custom settings, objects, or permissions.

How do we solve these problems with this pattern?

Stub it out!

The Singleton pattern allows us to stub out the data we’re expecting, and test one method at a time (as a good test should). We can return “data” from downstream methods that we haven’t actually inserted, or specific dates and times.

For those of you intimately familiar with Apex development, this all might seem eerily similar to the Stub API — and it is! However, this is a fully customizable solution that allows you to stub out everything that you want without worrying about platform limitations.

            
          


#MVC architecture

MVC is known as an architectural pattern, which embodies three parts Model, View and Controller, or to be more exact it divides the application into three logical parts: the model part, the view and the controller. It was used for desktop graphical user interfaces but nowadays is used in designing mobile apps and web apps.


![alt text](https://www.freecodecamp.org/news/content/images/2021/04/MVC3.png)
https://www.freecodecamp.org/

History

Trygve Reenskaug invented MVC. The first reports on MVC were written when he was visiting a scientist at Xerox Palo Alto Research Laboratory (PARC) in 1978/79. At first, MVC was called “Thing Model View Editor” but rapidly changed it to “Model View Controller”.

The goal of Tygrve was to solve the problem of users controlling a large and complex data set. The practice of MVC has changed over the years. Since the MVC pattern was invented before web browsers, initially was used as an architectural pattern for graphical user interfaces(GUI).

Advantages of MVC
- MVC architecture will separate the user interface from business logic.
- Components are reusable.
- Easy to maintain.
- Different components of the application in MVC can be independently deployed and maintained.
- This architecture helpt to test components independently.

Disadvantages of MVC
- The complexity is high.
- Not suitable for small applications.
- The inefficiency of data access in view.

  #reference article
  https://www.automatetheplanet.com/category/series/designpatterns/
  https://engineering.salesforce.com/simplify-testing-with-the-singleton-pattern-1a53ba5c2c50/
  https://www.freecodecamp.org/news/singleton-design-pattern-pros-and-cons-e10f98e23d63/
  https://towardsdatascience.com/everything-you-need-to-know-about-mvc-architecture-3c827930b4c1
  https://medium.com/nerd-for-tech/lets-understand-the-design-patterns-and-the-power-of-singleton-design-pattern-aba13bdc32f
