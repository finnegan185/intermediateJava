/* File: Executive.java
 * Author: Zachary Finnegan
 * Date: 1/24/2019
 * Purpose: This is a subclass of the Employee class and is used for
 * executive level employees and has stock price as an additional variable.
 */

package projectOne;

public class Executive extends Employee {
	//Executive exclusive variable
	private int stockPrice;
	//constructor
	public Executive(String empName, int empMonthlySalary, int stockPrice) {
		super(empName, empMonthlySalary);
		this.stockPrice = stockPrice;
	}
	//overridden annual salary method
	public int getAnnualSalary() {
		int empAnnualSalary;
		if (stockPrice > 50) {
			empAnnualSalary = super.getAnnualSalary() + 30000;
		} else {
			empAnnualSalary = super.getAnnualSalary();
		}
		return empAnnualSalary;
	}
	//overridden toString method for Executive. Adds stock price
    public String toString() {
    	String empDetails = super.toString();
    	empDetails += "\nStock Price: $" + formatter.format(this.stockPrice);
    	return empDetails;
    }
	public static void main(String[] args) {
		
	}
}
