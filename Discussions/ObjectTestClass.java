package Discussions;

import java.util.Scanner;

public class ObjectTestClass {
	private static Scanner userInput = new Scanner(System.in);

	public static boolean getFilled() {
		boolean userAnswer;
		System.out.println("Please enter a boolean answer (true or false for the following statement. " +
				"\nThe object is filled.");
		while(!userInput.hasNextBoolean()) {
			System.out.println("That is not a valid boolean value! Try again. ");
			userInput.next();
		}
		userAnswer = userInput.nextBoolean();
		return userAnswer;
	}

	public static double getUsableNumber() {
		double usableNumber;
		do {
			System.out.println("Enter a positive number. ");
			while(!userInput.hasNextDouble()) {
				System.out.println("That is not a number! Try again. ");
				userInput.next();
			}
			usableNumber = userInput.nextDouble();
		} while (usableNumber < 0.0);
		return usableNumber;
	}

	public static void main(String[] args) {
		double width;
		double height;
		double side1;
		double side2;
		double side3;
		double radius;
		String objColor;
		boolean objFilled;
		// Start and circle creation
		System.out.println(
				"We're going to create some shapes. " + "\nLet's start with a circle. Enter a color for the cirlce?");
		objColor = userInput.nextLine();
		objFilled = getFilled();
		System.out.println("What is the radius of the circle?");
		radius = getUsableNumber();
		Circle circle1 = new Circle(objColor, objFilled, radius);
		//Triangle creation
		System.out.println("Let's create a triangle next. Enter a color: ");
		objColor = userInput.next();
		objFilled = getFilled();
		System.out.println("What is the length of side 1 of the triangle?");
		side1 = getUsableNumber();
		System.out.println("What is the length of side 2 of the triangle?");
		side2 = getUsableNumber();
		System.out.println("What is the length of side 3 of the triangle?");
		side3 = getUsableNumber();
		Triangle triangle1 = new Triangle(objColor, objFilled, side1, side2, side3);
		//Rectangle creation
		System.out.println("Let's create a rectangle next. Enter a color: ");
		objColor = userInput.next();
		objFilled = getFilled();
		System.out.println("What is the height of the rectangle?");
		height = getUsableNumber();
		System.out.println("What is the width of the rectangle?");
		width = getUsableNumber();
		Rectangle rectangle1 = new Rectangle(objColor, objFilled, width, height);
		
		userInput.close();
		
		System.out.println("--------Your Shapes-------\n");
		System.out.println(circle1.toString() + "\nArea: " + circle1.getArea() + 
				"\nPerimeter: " + circle1.getPerimeter() + "\nDiameter: " + circle1.getDiameter() + "\n");
		System.out.println(triangle1.toString() + "\nArea: " + triangle1.getArea() + 
				"\nPerimeter: " + triangle1.getPerimeter() + "\n");
		System.out.println(rectangle1.toString() + "\nArea: " + rectangle1.getArea() + 
				"\nPerimeter: " + rectangle1.getPerimeter() + "\n");
		System.out.println("If you didn't like your shapes, try again.");
	}

}
