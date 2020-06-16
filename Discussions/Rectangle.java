package Discussions;

public class Rectangle extends GeometricObject {
	private double width = 2.0;
	private double height = 2.0;

	public Rectangle() {

	}

	public Rectangle(double width, double height) {
		this.setWidth(width);
		this.setHeight(height);
	}

	public Rectangle(String objColor, boolean objFilled, double width, double height) {
		super(objColor, objFilled);
		this.setWidth(width);
		this.setHeight(height);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getPerimeter() {
		return 2 * (height + width);
	}

	public double getArea() {
		return width * height;
	}

	public String toString() {
		String objDescription = "\nRectangle: \n" + super.toString() + "\nwidth = " + width + " height = " + height;
		return objDescription;
	}

	public static void main(String[] args) {

	}
}