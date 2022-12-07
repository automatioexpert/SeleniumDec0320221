package testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestCaseClass {
    WebDriver driver = null;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximize browser window
        driver.manage().deleteAllCookies(); // delete all cookies
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // set a maximum timeout for searching out the WebElements before throwing an exception

    }

    @After
    public void cleanUp(){
        driver.quit();
    }

    @Test
    public void t01_ValdiateSignUp() throws InterruptedException {

        // Invoking the browser with given URL
        driver.get("http://demo.automationtesting.in/Index.html");

        // Finding the WebElement of SearchBox for username field
        WebElement userNameField = driver.findElement(By.tagName("input"));

        // Entering Text into User Name field
        userNameField.sendKeys("test@gmail.com");

        // Clicking on proceed button
        WebElement proceedButton = driver.findElement(By.id("enterimg"));
        proceedButton.click();

        String expectedTitle = "Register";
        String actualTitle = driver.getTitle();

        Thread.sleep(5000);

        //Assertion
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @Test
    public void t02_ValidateUserIsAbleToRegister() throws InterruptedException {

        driver.get("http://demo.automationtesting.in/Register.html");

        WebElement firstNameField = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        firstNameField.sendKeys("Tom");

        WebElement lastNameField = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastNameField.sendKeys("Peter");

        WebElement addressField = driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));
        addressField.sendKeys("301, West Street, NYC");

        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.sendKeys("tompeter@gmail.com");

        WebElement phoneNumberField = driver.findElement(By.xpath("//input[@type='tel']"));
        phoneNumberField.sendKeys("8956457855");

        WebElement genderField = driver.findElement(By.xpath("//input[@value='Male']"));
        genderField.click();

        WebElement cricketHobbyRadioBtn = driver.findElement(By.id("checkbox1"));
        cricketHobbyRadioBtn.click();

        WebElement hockeyHobbyRadioBtn = driver.findElement(By.id("checkbox3"));
        hockeyHobbyRadioBtn.click();

        WebElement passwordField = driver.findElement(By.id("firstpassword"));
        passwordField.sendKeys("123@Xyz");

        WebElement ConfirmPasswordField = driver.findElement(By.id("secondpassword"));
        ConfirmPasswordField.sendKeys("123@Xyz");

        WebElement submitButton = driver.findElement(By.id("submitbtn"));
        submitButton.click();

        Thread.sleep(2000);

        //Assertions


    }



}
