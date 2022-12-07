package inheritance;

public class InhertingA extends SuberClass{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	SuberClass tr=new SuberClass();
	tr.addition();
	tr.calculateGrade (59, 89, 90);
	tr.age("89");
	
	InhertingA object = new InhertingA();
		
	}
	public void substraction(){
		int l=15;
		int h=45;
		int f=h-l;
		System.out.println("The total value :" +f);
	}
	
	public void addition (){
		System.out.println("This is overriding of addition");
	}
	public void calculateGrade(){
		System.out.println("This is overriding of calculateGrade");
	}
	public void age(){
		System.out.println("This is overriding of age");
	}

}
