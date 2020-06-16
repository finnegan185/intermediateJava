package Discussions;

import java.lang.Math;

public class Triangle extends GeometricObject {
	private double side1 = 2.0;
	private double side2 = 2.0;
	private double side3 = 2.0;

	public Triangle() {

	}

	public Triangle(double side1, double side2, double side3) {
		this.setSide1(side1);
		this.setSide2(side2);
		this.setSide3(side3);
	}

	public Triangle(String objColor, boolean objFilled, double side1, double side2, double side3) {
		super(objColor, objFilled);
		this.setSide1(side1);
		this.setSide2(side2);
		this.setSide3(side3);

	}

	public static void main(String[] args) {

	}

	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) {
		this.side1 = side1;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}

	public double getSide3() {
		return side3;
	}

	public void setSide3(double side3) {
		this.side3 = side3;
	}

	public double getArea() {
		double s = (side1 + side2 + side3) * (1.0 / 2);
		double area = Math.sqrt((s * (s - side1) * (s - side2) * (s - side3)));
		return area;
	}

	public double getPerimeter() {
		double perimeter = (side1 + side2 + side3);
		return perimeter;
	}

	public String toString() {
		String objDescription =  "\nTriangle: \n" + super.toString() + "\nside1 = " + side1 + " side2 = " + side2 + " side3 = "
				+ side3;
		return objDescription;
	}
}
