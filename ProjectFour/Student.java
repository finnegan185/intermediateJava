/* File: Student.java
 * Author: Zachary Finnegan
 * Date: 3/9/2019
 * Purpose: Project 4 for Intermediate Programming. This is the student class used by StudentDatabase
 * to create students that will be store in a hashmap. Main fields are name, mahor and GPA.
 */

package ProjectFour;

import java.text.DecimalFormat;
import java.util.HashMap;

public class Student {
	//Fields for student class
	private String name, major;
	private double gpa, gradePtTot;
	private int creditHrTot;
	private DecimalFormat gpaFormat = new DecimalFormat("#0.00");
	
	//HashMap for grades
	@SuppressWarnings("serial")
	private static HashMap<String, Double> gradeMap = new HashMap<String, Double>(){{
					put("A", 4.0);
					put("B", 3.0);
					put("C", 2.0);
					put("D", 1.0);
					put("F", 0.0);
	}};
	//Basic unused constructor
	public Student() {	
	
	}
	//Constructor used by StudentDatabase
	public Student(String name, String major) {
		this.name = name;
		this.major = major;
		this.gpa = 0.0;
	}
	//Constructor just in case
	public Student(String name, String major, double gpa) {
		this.name = name;
		this.major = name;
		this.gpa = gpa;
	}
	//method activated by StudentDatabse updateStudent method
	public boolean courseCompleted(String grade, int credits) {
		this.gradePtTot += gradeMap.get(grade)*credits;
		this.creditHrTot += credits;
		this.gpa = gradePtTot/creditHrTot;
		return true;
	}
	//toString method used in the findStudent method
	public String toString() {
		String theString = "Name: " + getName() + "\nMajor: " + 
				getMajor() + "\nGPA: " + gpaFormat.format((getGpa()));
		return theString;
	}
	
	//getters
	public double getGpa() {
		if (this.gpa == 0.0) {
			return 4.0;
		} else {
			return gpa;
		}
	}

	public String getName() {
		return name;
	}

	public String getMajor() {
		return major;
	}

	//Setters are mostly unused in this program
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public static void main(String[] args) {
		
		
	}



}
