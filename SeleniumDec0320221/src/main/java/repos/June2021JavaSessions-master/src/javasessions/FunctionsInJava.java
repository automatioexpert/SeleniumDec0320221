package javasessions;

public class FunctionsInJava {
	//functions -- are also class data members
	
	//can not create a fun inside a function
	//functions can not duplicate
	//to call the function - we need to create the Object
	
	//three types of functions:
	
	//1. no input and no return:
	//void: no return from the function
	//return type: void
	public void test() {//0 input param
		System.out.println("test method....");
	}
	
	//2. no input and some return:
	//return type: String
	public String getTrainerName() {
		System.out.println("get trainer name....");
		String name = "Naveen";
		return name;
	}

	public int getPopulationCount() {
		System.out.println("get pop count..");
		int india = 100;
		int US = 50;
		int finalCount = india + US;
		return finalCount;
	}
	
	//3. some input and some return:
	//return type: int
	public int add(int a, int b) {
		System.out.println("add method");
		int z = a+b;
		return z;
	}
	
	//WAF - where we have to pass the student name(String) -- ip parameter
	//return - stundet marks (int)
	
	public int getStudentMarks(String name) {
		System.out.println("getting student marks for : " + name);
		int marks = -1;
		if(name.equals("sachin")) {
			marks = 90;
		}
		else if(name.equals("nancy")) {
			marks = 95;
		}
		else if(name.equals("bhumika")) {
			marks = 100;
		}
		else {
			System.out.println("student name : " + name + " is not found....");
		}
		return marks;
	}
	
	
	public static void main(String[] args) {
		FunctionsInJava obj = new FunctionsInJava();
		obj.test();
		String n = obj.getTrainerName();
		System.out.println(n);
		
		System.out.println(obj.getTrainerName());
		
		int pop = obj.getPopulationCount();
		System.out.println(pop);
		
		int sum = obj.add(10, 20);
		System.out.println(sum);
		
		int sum1 = obj.add(100, 105);
		System.out.println(sum1);
		
		int m1 = obj.getStudentMarks("naveen");
		System.out.println(m1);
		if(m1==-1) {
			System.out.println("this student is not in our school...");
		}
		
		int m2 = obj.getStudentMarks("bhumika");
		System.out.println(m2);
		
		int m3 = obj.getStudentMarks("Tom");
		System.out.println(m3);
		
		String mesg = obj.launchBrowser("firefox");
		System.out.println(mesg);
		
	}
	
	//WAF - where I need to pass the browserName(String)
	//return the same browser name with a messg: "chrome is launched"
	public String launchBrowser(String browserName) {
		System.out.println("browser name is : " + browserName);
		
		switch (browserName) {
		case "chrome":
			return browserName+" is launched - 200OK";
		case "firefox":
			return browserName+" is launched";
		case "safari":
			return browserName+" is launched";

		default:
			System.out.println("please pass the right browser name.....");
			return "BROWSERNOTFOUND --- 404 ERROR";
			
		}
		
	}
	
	
	

}
