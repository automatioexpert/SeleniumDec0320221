package modifiers;

public class Modifiers_permission {
	static int length=60;
	static int width=8;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Modifiers_permission creat=new Modifiers_permission();
		creat.area();
		creat.circle();
	}
	public void area (){
		int length=600;
		int areas=length*width;
		System.out.println(areas);
	}
	public void circle(){
		int circlesd=length+width;
		System.out.println(circlesd);
	}

}
