package learn_abstract;

public class Over extends CreateAbstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Over object =new Over();
		object.addition();
		object.substraction1();
     
	}

	@Override
	public void addition() {
		// TODO Auto-generated method stub
		System.out.println("this is addition");
	}

	@Override
	public void substraction1() {
		// TODO Auto-generated method stub
		System.out.println("this is substraction");
		
	}

}
