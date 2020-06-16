/* File: Employee.java
 * Author: Zachary Finnegan
 * Date: 1/24/2019
 * Purpose: This is the Employee class and is used for capturing employee
 * information for later usage and processing. 
 */

package projectOne;

import java.text.DecimalFormat;

public class Employee {
    //Class variables
	private String empName;
	private int empMonthlySalary;
	protected static DecimalFormat formatter = new DecimalFormat("#,###");
    //Constructor
    public Employee(String empName, int empMonthlySalary) {
		this.empName = empName;
		this.empMonthlySalary = empMonthlySalary;
	}
    //Method for calculating and returning yearly salary
    public int getAnnualSalary() {
    	int empAnnualSalary = this.empMonthlySalary*12;
    	return empAnnualSalary;
    }
    //toString Method
    public String toString() {
    	String empDetails = ("Employee Name: " + this.empName + 
    			"\nMonthly Salary: $" + formatter.format(this.empMonthlySalary));
    	return empDetails;
    }
	public static void main(String[] args) {


	}

}
