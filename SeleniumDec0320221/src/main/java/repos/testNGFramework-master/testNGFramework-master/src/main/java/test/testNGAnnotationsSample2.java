package test;


import org.testng.annotations.*;

public class testNGAnnotationsSample2 {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("Before Suite");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("After Suite");
    }

    @Test(groups = {"Smoke"})
    public void Test3() {
        System.out.println("Test 3");
    }

    @Test
    public void Test4() {
        System.out.println("Test 4");
    }
}
