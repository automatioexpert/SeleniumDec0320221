package classes;

public class Circle extends Shape {
	private double radius;
	private double pi;
	
	public Circle(double radius){
		this.radius = radius;
		pi = Math.PI;
	}
	

	@Override
	public double area() {
		return pi * Math.pow(radius, 2);
	}
	
	
	@Override
	public double perimeter() {
		return 2 * pi * radius;
	}

}
