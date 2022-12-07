package overridingPractice;

public class TestB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TestA object=new TestA();
		//object.tesb();
		//obj.getAlm();
		TestA create=new TestA("Hassen");
		create.addition();
		create.addition(10.3f, 5.8f, 9.7f);
		
		//String atmupdateids=object.getAtm();
		//System.out.println(atmupdateids);
		
		//object.setAtm("String");
		//object.setAtm("Saleem");
		//object.addition(5, 8, 9, 10);
		//object.addition(10, 5, 5);
		//object.addition(5.5f, 8.3f, 9.6f);
	}

}
