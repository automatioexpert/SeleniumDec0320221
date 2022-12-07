package com.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListObjectSortExample {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Sachin", 47, 1000));
		people.add(new Person("Chris", 34, 900));
		people.add(new Person("Rajeev", 25, 2400));
		people.add(new Person("David", 31, 8700));

		System.out.println("Person List : " + people);

		// Sort People by their Age
		/*
		 * people.sort((person1, person2) -> { return person1.getAge() -
		 * person2.getAge(); });
		 */
		// A more concise way of writing the above sorting function
		people.sort(Comparator.comparingInt(Person::getAge));

		people.forEach(person -> {
			System.out
					.println("Name " + person.getName() + " Age " + person.getAge() + " Salary " + person.getSalary());
		});

		System.out.println("Sorted Person List by Age : " + people);

		// You can also sort using Collections.sort() method by passing the custom
		// Comparator
		Collections.sort(people, Comparator.comparing(Person::getName));
		System.out.println("Sorted Person List by Name : " + people);

		Collections.sort(people, Comparator.comparingInt(Person::getSalary));
		System.out.println("Sorted Person List by Salary : " + people);

	}

}

class Person {
	private String name;
	private Integer age;
	private Integer salary;
	

	public Person(String name, Integer age, Integer salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public Integer getSalary() {
		return salary;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "{" + "name='" + name + '\'' + ", age=" + age + ", salary=" + salary + '}';
	}
}
