/* File: Salesman.java
 * Author: Zachary Finnegan
 * Date: 1/24/2019
 * Purpose: This is a subclass of the Employee class and is used for
 * salesman employees and has annual sales as an additional variable.
 */

package projectOne;

public class Salesman extends Employee {
    //Salesman specific field
	public int annualSales;
    //Salesman constructor utilizing super keyword
	public Salesman(String empName, int empMonthlySalary, int annualSales) {
		super(empName, empMonthlySalary);
		this.annualSales = annualSales;
	}
	//Salesman getAnnualSalary Override
	public int getAnnualSalary() {
		double empCommission = this.annualSales*.02;
		if (empCommission > 20000) {
			empCommission = 20000;
		}
		int empAnnualSalary = (int) (super.getAnnualSalary() + empCommission);
		return empAnnualSalary;
	}
	//overridden toString method for Salesman. Adds annual sales
    public String toString() {
    	String empDetails = super.toString();
    	empDetails += "\nAnnual Sales: $" + formatter.format(this.annualSales);
    	return empDetails;
    }
	public static void main(String[] args) {


	}

}
