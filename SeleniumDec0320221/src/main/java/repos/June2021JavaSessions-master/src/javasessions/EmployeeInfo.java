package javasessions;

import java.util.ArrayList;

public class EmployeeInfo {

	String name;
	int age;
	ArrayList<String> devicesList;

	public EmployeeInfo(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public EmployeeInfo(String name, int age, ArrayList<String> devicesList) {
		this.name = name;
		this.age = age;
		this.devicesList = devicesList;
	}

	public EmployeeInfo(String name, ArrayList<String> devicesList) {
		this.name = name;
		this.devicesList = devicesList;
	}

}
