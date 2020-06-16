/* File: EmployeeReadNReport.java
 * Author: Zachary Finnegan
 * Date: 1/24/2019
 * Purpose: This program implements the employee class and subclasses
 * to store employee information that is read from a txt file. 
 * The information is then output in a report of all the employees for 
 * each year with the employees information.
 */

package projectOne;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;


public class EmployeeReadNReport {
	//Employee arrays
	private static Employee[] emp2014Array = new Employee[10];
	private static Employee[] emp2015Array = new Employee[10];
	
	//Scanner for user input creation and formatter
	private static Scanner userInput = new Scanner(System.in);
	private static DecimalFormat formatter = new DecimalFormat("#,###");
	//Class variables
	private static int total2014Salary;
	private static int total2015Salary;
	private static int counter2014 = 0;
	private static int counter2015 = 0;
	
	//Employee class instance creation and collection in arrays method
	public static void setEmployeeArrays(String fileName) {
		//input variables
		String line = "";
		String empName;
		int empMonthlySalary;
		int annualSales;
		int stockPrice;	
		
		//try block and or loop to test if input filename works
		try (BufferedReader inputStream = new BufferedReader(new FileReader(fileName))){
			while((line = inputStream.readLine()) != null) {
				String[] splitLine = line.split(" ");
				
				//creating employee instances for 2014 from file
				if(splitLine[0].equals("2014")) {
					empName = splitLine[2];
					empMonthlySalary = Integer.parseInt(splitLine[3]);
					if(splitLine[1].equals("Employee")) {
						emp2014Array[counter2014] = new Employee(empName, empMonthlySalary);
					}else if(splitLine[1].equals("Salesman")) {
						annualSales = Integer.parseInt(splitLine[4]);
						emp2014Array[counter2014] = new Salesman(empName, empMonthlySalary, annualSales);
					}else if(splitLine[1].equals("Executive")) {
						stockPrice = Integer.parseInt(splitLine[4]);
						emp2014Array[counter2014] = new Executive(empName, empMonthlySalary, stockPrice);
					}else {
						System.out.println(getEmpErrorMsg(splitLine[1]));
						continue;
					}
					counter2014++;
				}else if(splitLine[0].equals("2015")) {
					empName = splitLine[2];
					empMonthlySalary = Integer.parseInt(splitLine[3]);
					if(splitLine[1].equals("Employee")) {
						emp2015Array[counter2015] = new Employee(empName, empMonthlySalary);
					}else if(splitLine[1].equals("Salesman")) {
						annualSales = Integer.parseInt(splitLine[4]);
						emp2015Array[counter2015] = new Salesman(empName, empMonthlySalary, annualSales);
					}else if(splitLine[1].equals("Executive")) {
						stockPrice = Integer.parseInt(splitLine[4]);
						emp2015Array[counter2015] = new Executive(empName, empMonthlySalary, stockPrice);
					}else {
						System.out.println(getEmpErrorMsg(splitLine[1]));
						continue;
					}
					counter2015++;
				}else {
					System.out.println("Year of employee information not recognized. Entered: " + splitLine[0]);
				}
				
			}

		} catch (IOException e) {
			e.printStackTrace();
					
		} finally {
			userInput.close();
		}
		
	}//end of setEmployeeArrays
	
	private static String getEmpErrorMsg(String empTypeEntered) {
		String errorMsg = "Type of employee isn't recognized. Entered: " + empTypeEntered;
		return errorMsg;
	}
	//Method for printing employee information sorted by year
	public static String getEmployeeInfo(Employee empInstance, String year) {
		if(year.equals("2014")) {
			total2014Salary += empInstance.getAnnualSalary();
		} else if(year.equals("2015")) {
			total2015Salary += empInstance.getAnnualSalary();
		} else {
			System.out.println("Something went wrong in getEmployeeInfo sorting years.");
		}
		String empInfo = empInstance.toString() + "\nAnnual Salary: $" + formatter.format(empInstance.getAnnualSalary());
		
		return empInfo;
	}
	
	//Main method
	public static void main(String[] args) throws IOException {
		//Ask for file name
		System.out.println("Please enter file name with .txt: ");
		String fileName = userInput.nextLine();
		
		//Call setEmployeeArrays method to read file and create employee classes
		setEmployeeArrays(fileName);
		
		//For loops and code for creating employee report based on year
		System.out.println("----------2014 Employee Report------------");
		int array2014Remainder = 10 - counter2014;
		for(int i=0; i < emp2014Array.length - array2014Remainder; i++) {
			System.out.println(getEmployeeInfo(emp2014Array[i], "2014") + "\n");
		}
		System.out.println("Average of all annual salaries of all employees for 2014: $" + formatter.format(total2014Salary/counter2014));
		
		//Start of 2015 report code
		int array2015Remainder = 10 - counter2015;
		System.out.println("\n\n----------2015 Employee Report------------");
		for(int i=0; i < emp2015Array.length - array2015Remainder; i++) {
			System.out.println(getEmployeeInfo(emp2015Array[i], "2015") + "\n");
		}
		System.out.println("Average of all annual salaries of all employees for 2015: $" + formatter.format(total2015Salary/counter2015));

	}

}
