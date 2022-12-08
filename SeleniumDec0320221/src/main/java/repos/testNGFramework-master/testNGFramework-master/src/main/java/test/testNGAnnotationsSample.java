package test;

import org.testng.annotations.*;
import util.CustomReporter;

@Listeners(CustomReporter.class)
public class testNGAnnotationsSample {

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Methid");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @Test(groups = {"Smoke"})
    public void Test1() {
        System.out.println("Test 1");
    }

    @Test()
    public void Test2() {
        System.out.println("Test 2");
    }
}
