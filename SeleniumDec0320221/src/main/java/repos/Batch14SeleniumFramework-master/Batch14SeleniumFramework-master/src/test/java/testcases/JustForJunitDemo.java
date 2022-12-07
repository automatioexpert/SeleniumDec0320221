package testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JustForJunitDemo {

    @Before
    public void setUp(){
        System.out.println("I am in before hook");
    }

    @After
    public void cleanUp(){
        System.out.println("I am in After hook");
    }

    @Test
    public void t1(){
        System.out.println("I am in t1");
    }

    public void t2(){
        System.out.println("I am in t2");
        Assert.fail("I am fail");
    }
    @Test
    public void t3(){
        System.out.println("I am in t3");
    }
    @Test
    public void t4(){
        System.out.println("I am in t4");
    }
}
