package constructorconcept;

import java.util.ArrayList;

public class Customer {

	String fistname;
	String lastname;
	boolean isPrime;
	String phone;
	String address;
	String email;
	ArrayList<String> ordersList;

	public Customer(String fistname, String phone, String email) {
		this.fistname = fistname;
		this.phone = phone;
		this.email = email;
		
		
	}

	public Customer(String fistname, String phone, String address, String email) {
		this.fistname = fistname;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}

	public Customer(String fistname, boolean isPrime, String phone, String email) {
		this.fistname = fistname;
		this.isPrime = isPrime;
		this.phone = phone;
		this.email = email;
	}

	public Customer(String fistname, String lastname, ArrayList<String> ordersList) {
		this.fistname = fistname;
		this.lastname = lastname;
		this.ordersList = ordersList;
	}

	public Customer(String fistname, String lastname, boolean isPrime, 
			String phone, String address, String email,
			ArrayList<String> ordersList) {
		this.fistname = fistname;
		this.lastname = lastname;
		this.isPrime = isPrime;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.ordersList = ordersList;
	}

}
