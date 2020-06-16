package ProjectTwo;
/* File: Account.java
 * Author: Zachary Finnegan
 * Date: 6 February 2019
 * Purpose: Class used by AutomatedTellerMachine. Creates bank accounts with the ability to withdraw, deposit and get balance.
 */

import java.text.NumberFormat;

public class Account {
	//class variable creation and one field
	private static int withdrawalNum = 0;
	private static final double serviceCharge = 1.50;
	private double accountBalance = 2000.00;
	private static NumberFormat currency = NumberFormat.getCurrencyInstance();
	
	//method to process withdrawals, ensuring service charge is used correctly and there are adequate funds for withdrawal. 
	public boolean withdrawal(double amtToWithdraw) throws InsufficientFundsException {
		if (withdrawalNum >= 4) {
			amtToWithdraw += serviceCharge;
		}
		if (amtToWithdraw <= accountBalance) {
			this.accountBalance -= amtToWithdraw;
			withdrawalNum++;
			return true;
		} else {
			throw new InsufficientFundsException("Insufficient Funds");
		}
	}
	
	//set balance if more or less than $2000 is desired
	public void setAccountBalance(double howMuch) {
		this.accountBalance = howMuch;
	}
	
	//method for deposits
	public void deposit(double amtDeposited) {
		this.accountBalance += amtDeposited;
	}
	
	//method for balance requests
	public String getAccountBalance() {
		return currency.format(accountBalance);
	}

	//Basic Constructor
	public Account() {

	}
	
	//Constructor for setting initial account balance
	public Account(double howMuch) {
		this.accountBalance = howMuch;
	}
	
	//method for returning number of withdrawal across all instance of Account class
	public static int getWithdrawalNum() {
		return withdrawalNum;
	}
	
	//method for getting service charge nicely formated
	public static String getServiceCharge() {
		return currency.format(serviceCharge);
	}
	
	public static void main(String[] args) {

	}

}
