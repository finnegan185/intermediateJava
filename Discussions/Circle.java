package Discussions;

public class Circle extends GeometricObject {
	private double radius = 2.0;

	public Circle() {

	}

	public Circle(String objColor, boolean objFilled, double radius) {
		super(objColor, objFilled);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}

	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	public double getDiameter() {
		return radius * 2.0;
	}

	public String toString() {
		String objDescription = "\nCircle: \n" + super.toString() + "\nradius = " + radius;
		return objDescription;
	}

}
