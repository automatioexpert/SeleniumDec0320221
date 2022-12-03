package JavaSessions;

public class Customer {
	
	//non static methods, class vars: data members of the class
	//function can not created inside a function
	//functions are parallel to each other
	//functions are always independent to each other
	
	//return type: void: can not return any value
	//default fun: 0 param
	//1. no input and no return
	public void test() {
		System.out.println("test method");
		int a = 10;
		System.out.println(a+20);
	}
	
	//2. no input and some return
	//return type: int
	public int getMarks() {
		System.out.println("get marks method");
		int a = 10;
		int b = 20;
		int c = 90;
		int total = a+b+c;
		return total;
	}
	
	//return type: String
	public String getTrainerName() {
		System.out.println("get trainer name");
		String name = "Naveen";
		return name;
	}
	
	//3. some input and some return:
	public int add(int a, int b) {
		System.out.println("add method");
		int sum = a+b;
		return sum;
	}
	
	//WAF:
	//getStundetMarks
	//input param: name (String)
	//return marks (int)
	
	public int getStudentMarks(String name) {
		System.out.println("getting student marks for: " + name);
		int marks = -1;
		
		if(name.equalsIgnoreCase("Muneeb")) {
			marks = 90;
		}
		else if(name.equalsIgnoreCase("Ravish")) {
			marks = 95;
		}
		else if(name.equalsIgnoreCase("Anu")) {
			marks = 80;
		}
		else if(name.equalsIgnoreCase("Naveen")) {
			marks = 10;
		}
		else {
			System.out.println("please pass the right student name: " + name);
		}
		
		return marks;
	}
	
	

	public static void main(String[] args) {
		
		//call a function: have to create the object of this class
		Customer obj = new Customer();
		obj.test();
		int t = obj.getMarks();
		System.out.println(t+50);
		
		//System.out.println(obj.getMarks()+30);
		String n = obj.getTrainerName();
		System.out.println("the trainer name is: " + n);
		
		int s1 = obj.add(20, 30);
		System.out.println(s1);
		
		int m1 = obj.getStudentMarks("anu");
		System.out.println(m1);
		
		int m2 = obj.getStudentMarks("Tom");
		if(m2==-1) {
			System.out.println("wrong student....");
		}
		
	}

	
	
}
