package constructorconcept;

import java.util.ArrayList;

public class Booking {

	String name;
	String userid;
	ArrayList<Integer> bookingList;

	public Booking(String name, String userid, ArrayList<Integer> bookingList) {
		this.name = name;
		this.userid = userid;
		this.bookingList = bookingList;
	}

	public static void main(String[] args) {

		ArrayList<Integer> ar = new ArrayList();
		ar.add(5001);
		ar.add(5002);
		ar.add(5011);
		ar.add(5022);

		Booking b1 = new Booking("Naveen", "101", ar);
		System.out.println(b1.name + " " + b1.bookingList);
		
		
		
		System.out.println(b1.bookingList.size());
		
		ArrayList<Integer> ar1 = new ArrayList();
		Booking b2 = new Booking("Neel", "102", ar1);
		System.out.println(b2.name + " " + b2.bookingList);
		System.out.println(b2.bookingList.size());
		System.out.println(b2.bookingList.get(0));



		
	}

}
