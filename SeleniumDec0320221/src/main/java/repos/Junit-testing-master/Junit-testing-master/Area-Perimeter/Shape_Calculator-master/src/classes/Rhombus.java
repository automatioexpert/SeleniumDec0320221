package classes;

public class Rhombus extends Shape {
	private double length;
	private double height;
	
	
	public Rhombus(double length, double height){
		this.length = length;
		this.height = height;
	
	}
	

	@Override
	public double area() {
		return length * height;
	}
	
	@Override
	public double perimeter() {
		return 4 * length;
	}
	
}
