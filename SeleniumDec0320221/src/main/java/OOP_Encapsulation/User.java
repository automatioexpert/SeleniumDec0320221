package OOP_Encapsulation;

public class User {

	// create a user, get the user info, but update is not allowed -- const, getter
	// create a user, get the user info, but update is also allowed -- const, getter and setter

	private String name;
	private int age;
	private boolean isActive;

	public User(String name, int age, boolean isActive) {
		this.name = name;
		this.age = age;
		this.isActive = isActive;
	}

	// public getter and setter
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
