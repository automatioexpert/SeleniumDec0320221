package javasessions;

public class Customer {

	// method/function:
	// can not create a method inside a method

	// 1. no input and no return:
	// void: can not return anything
	// return type: void
	public void test() {// 0 input parameter function
		System.out.println("test method...");
	}

	public void printMyName() {
		System.out.println("my name is naveen");
		String name = "Naveen Automation Labs";
		System.out.println(name);
	}

	// 2. no input and some return:
	// return type: int
	public int getNumber() {
		System.out.println("get number....");
		int num = 100;
		int num1 = 200;
		int sum = num + num1;
		System.out.println(sum);
		return sum;
	}
	
	public String getTrainerName() {
		System.out.println("get trainer name....");
		String name = "Naveen";
		return name;
	}
	
	public int getBillAmout() {
		int a = 100;
		int b = 200;
		int c = 300;
		int z = a+b+c;
		return z;
	}
	
	//3. some input and some return:
	//two input paramater
	public int add(int a, int b) {
		System.out.println("add method...");
		int total = a+b;
		return total;
	}
	
	//WAF: name: getMarks
	//input parameter: studentName(String)
	//return: marks (int)
	public int getMarks(String studentName) {
		System.out.println("student name is : " + studentName);
		
		if(studentName.equals("Vijay")) {
			return 90;
		}
		else if(studentName.equals("Amaan")) {
			return 95;
		}
		else if(studentName.equals("Priyanka")) {
			return 100;
		}
		else if(studentName.equals("Naveen")) {
			return 0;
		}
		else {
			System.out.println("student name is not found....please pass the right st name" + studentName);
			return -1;
		}
	}
	
	public int getStudentMarks(String studentName) {
		System.out.println("student name is : " + studentName);
		int marks = -1;
		
		if(studentName.equals("Vijay")) {
			marks = 100;
		}
		else if(studentName.equals("Amaan")) {
			marks = 90;
		}
		else if(studentName.equals("Priyanka")) {
			marks = 95;
		}
		else if(studentName.equals("Naveen")) {
			marks = 10;
		}
		else {
			System.out.println("student name is not found....please pass the right st name" + studentName);
		}
		
		return marks;
	}
	public static void main(String[] args) {

		// create the object of the class:
		Customer obj = new Customer();
		obj.test();
		obj.printMyName();
		int s1 = obj.getNumber();
		System.out.println(s1+10);
		
		System.out.println(obj.getNumber());
		String n1 = obj.getTrainerName();
		System.out.println(n1);
		
		int totalAmount = obj.getBillAmout();
		System.out.println(totalAmount + 50 - 10);
		
		int m1 = obj.add(10, 20);//arguments
		System.out.println(m1);
		
		int m2 = obj.add(100, 2000);
		System.out.println(m2-100);
		
		int mk = obj.getMarks("Vijay");
		System.out.println(mk);
		
		if(mk == -1) {
			System.out.println("dont print the marksheet");
		}
		
		int mr = obj.getStudentMarks("Tom");
		System.out.println(mr);
		
	}

}
