package bridgelabz.TestNG.Annotations;

import org.testng.annotations.Test;

public class Priority_annotations {
	
	//It will execute after test whose priority is '2'
	@Test(priority=3)
    public void c_method(){
    System.out.println("This is method C");
    }
	
	//It will execute after first test whose priority is '0'
    @Test(priority=1)
    public void b_method(){
    System.out.println("This is method B");
    }
    
    //It will execute first
    @Test(invocationCount=2,priority=0)     //Invoking this methods for two times
    public void a_method(){
    System.out.println("This is method A");
    }
    
    //It will execute after test with priority of 4
    @Test(priority=5)
    public void e_method(){
    System.out.println("This is method E");
    }
    
    //It will execute after test with priority of 3
    @Test(priority=4)
    public void d_method(){
    System.out.println("This is method D");
    }
}
