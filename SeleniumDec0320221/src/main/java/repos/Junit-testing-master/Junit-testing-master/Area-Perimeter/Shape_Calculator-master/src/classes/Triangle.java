package classes;

public class Triangle extends Shape {
	private double base;
	private double height;
	private double lengthSide1, lengthSide2, lengthSide3;
	
	public Triangle(double base, double height, double lengthSide1, double lengthSide2, double lengthSide3){
		this.base = base;
		this.height = height;
		this.lengthSide1 = lengthSide1;
		this.lengthSide2 = lengthSide2;
		this.lengthSide3 = lengthSide3;
	}
	
	
	@Override
	public double area() {
		return ((base * height) / 2);
	}
	
	
	@Override
	public double perimeter() {
		return lengthSide1 + lengthSide2 + lengthSide3;
	}

}
