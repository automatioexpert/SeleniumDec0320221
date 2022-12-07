import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import classes.Circle;
import classes.Rectangle;
import classes.Rhombus;
import classes.Triangle;

class Sample_Test {
	
	//Circle
	@Test
	public void testArea1() {
		Circle circle = new Circle(5);
		assertTrue(Math.PI * Math.pow(5, 2) == circle.area());
	}
	
	@Test
	public void testPerimeter1(){
		Circle circle = new Circle(5);
		assertTrue(2 * Math.PI * 5 == circle.perimeter());
	}
	
	//Rectangle
	@Test
	public void testArea2() {
		Rectangle rectangle = new Rectangle(8, 3);
		assertTrue(24 == rectangle.area());
        
	}
	
	@Test
	public void testPerimeter2(){
		Rectangle rectangle = new Rectangle(5, 5);
		assertTrue(20 == rectangle.perimeter());
	}

	//Rhombus
	@Test
	public void testArea3() {
		Rhombus rhombus = new Rhombus(6.7, 6);
		assertTrue(40.2 == rhombus.area());
	}
	
	@Test
	public void testPerimeter3(){
		Rhombus rhombus = new Rhombus(6.7, 6);
		assertTrue((4 * 6.7) == rhombus.perimeter());
	}
	
	//Triangle
	@Test
	public void testArea4() {
		Triangle triangle = new Triangle(15, 4, 0, 0 , 0);
		assertTrue(30 == triangle.area());
	}
	
	@Test
	public void testPerimeter4(){
		Triangle triangle = new Triangle(15, 8, 12, 10 , 10);
		assertTrue(32 == triangle.perimeter());
	}
	
//	@Test
//	public void testtemp()
//	{
//		gui.MainWindow mw = new gui.MainWindow();
//		assertTrue(mw.get);
//	}
	
	
	
}
