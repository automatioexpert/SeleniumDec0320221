package javasessions;

public class CarBooking {

	//functon -> business logic //features 
	//constrcutor: temaplate of the class: used to initialize the class vars
	
	String carType;
	String from;
	String to;
	int code;
	
	public void booking() {
		System.out.println("car is booked with : " + carType +" "+ from +" "+ to);
	}
	
	public CarBooking() {//default const... 0 param
		System.out.println("car booking is called....");
	}

	public CarBooking(String carType, String from, String to) {
		this.carType = carType;
		this.from = from;
		this.to = to;
	}

	public CarBooking(String from, String to) {
		this.from = from;
		this.to = to;
	}

	public CarBooking(String carType, String from, String to, int code) {
		this.carType = carType;
		this.from = from;
		this.to = to;
		this.code = code;
	}

}
