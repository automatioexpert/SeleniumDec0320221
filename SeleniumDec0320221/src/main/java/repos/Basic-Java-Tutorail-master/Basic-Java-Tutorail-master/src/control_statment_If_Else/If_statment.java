package control_statment_If_Else;

public class If_statment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 6;
		if (x == 6) {
			System.out.println("The value of x is : " + x);
		} else if (x != 6) {
			if (x < 6 || x <= 6) {
				System.out.println("The value of x is less then 6 and it is :" + x);
			} else if (x > 6 || x >= 6) {
				System.out.println("The value of x is greater then 6 and it is :" + x);
			}
		}

		int y = 5;
		if (y == 5) {
			System.out.println("The value of y is equal: " + y);
		}
		if (y != 5) {
			System.out.println("The value of y is : " + y);
		}
		if (y < 5) {
			System.out.println("The value of y is : " + y);
		}
		if (y > 5) {
			System.out.println("The value of y is : " + y);
		}
		if (y >= 6) {
			System.out.println("The value of y is : " + y);
		}
		if (y <= 6) {
			System.out.println("The value of y is : " + y);
		}

	}

}
