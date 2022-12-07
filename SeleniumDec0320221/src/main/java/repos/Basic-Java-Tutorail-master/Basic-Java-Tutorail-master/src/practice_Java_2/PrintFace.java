package practice_Java_2;

public class PrintFace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myface();
	}
	public static void myface() {
       String [] arra=new String[5];
		
		arra[0]=" +\"\"\"\"\"+ ";
		arra[1]="[| o o |]";
		arra[2]=" |  ^  |";
		arra[3]=" | '-' |";
		arra[4]=" +-----+";

		for(int i=0;i<5;i++) {
			System.out.println(arra[i]);
		}
	}

}
