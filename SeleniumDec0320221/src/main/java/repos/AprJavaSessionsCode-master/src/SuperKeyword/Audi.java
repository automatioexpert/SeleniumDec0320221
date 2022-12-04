package SuperKeyword;

public class Audi extends Car {

	int speed = 200;

	public Audi() {
		super(10);
		System.out.println("Audi...const..");
	}

	@Override
	public void start() {
		System.out.println("Audi -- start");
		super.start();
		System.out.println(super.speed);// 100
		super.refuel();
		
	}

	public void getSpeed() {
		System.out.println(speed);// 200
		System.out.println(super.speed);// 100
	}

}
