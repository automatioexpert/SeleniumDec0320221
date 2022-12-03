package ConstrutorConcept;

public class EmployeeD {

	private String name;
	private int age;

	/**
	 * Create Employee class: define class vars with private: name, age, salary,
	 * isActive, Gender create public getter and setter for each class private vars
	 * create public getEmployeeInfo() method in Employee class which will return al
	 * the values of employee
	 **/

	public EmployeeD getEmployeeInfo() {
		return this;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
