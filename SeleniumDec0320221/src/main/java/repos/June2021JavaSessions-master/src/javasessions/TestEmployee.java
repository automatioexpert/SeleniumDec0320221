package javasessions;

import java.util.ArrayList;

public class TestEmployee {

	public static void main(String[] args) {

		EmployeeInfo e1 = new EmployeeInfo("Tom", 20);
		System.out.println(e1.devicesList);
		
		ArrayList<String> devList = new ArrayList<String>();
		devList.add("Iphone12");
		devList.add("iMac");
		devList.add("Samsung s8");

		EmployeeInfo e2 = new EmployeeInfo("Shalini", 25, devList);
		
		System.out.println(e2.name + " " + e2.age + " " + e2.devicesList);
		
		
		
		
	}

}
