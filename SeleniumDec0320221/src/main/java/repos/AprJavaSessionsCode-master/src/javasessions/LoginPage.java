package javasessions;

import java.util.Arrays;

public class LoginPage {
	
	String username;
	String password;
	boolean isActive;
	double bmi;
	int age;
	char gender;
	String st[] = {"tom", "lisa", "peter"};
	
	

	public static void main(String[] args) {

		LoginPage lp = new LoginPage();
		System.out.println(lp.age);
		
		System.out.println(lp.st.length);
		System.out.println(Arrays.toString(lp.st));
		for(String e : lp.st) {
			System.out.println(e);
		}
		
	}

}
