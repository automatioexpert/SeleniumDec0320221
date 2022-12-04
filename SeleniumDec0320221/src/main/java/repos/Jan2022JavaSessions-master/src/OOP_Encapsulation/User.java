package OOP_Encapsulation;

public class User {

	private String firstName;
	private String lastName;
	private long phone;
	private boolean isPrime;

	public User(String firstName, String lastName, long phone, boolean isPrime) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.isPrime = isPrime;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public boolean isPrime() {
		return isPrime;
	}

	public void setPrime(boolean isPrime) {
		this.isPrime = isPrime;
	}
	
	public void getUserProfile() {
		System.out.println(firstName + " " + lastName + " "+ phone + " "+ isPrime);
	}

}
