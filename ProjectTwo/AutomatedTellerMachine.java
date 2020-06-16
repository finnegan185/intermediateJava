package ProjectTwo;
/* File: AutomatedTellerMachine.java
 * Author: Zachary Finnegan
 * Date: 6 February 2019
 * Purpose: Virtual ATM GUI. Utilizes Account class and InsufficientFundsException
 */


import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.text.NumberFormat;

public class AutomatedTellerMachine extends JFrame{
	//Fields for GUI objects and Account instance creation
	private static final long serialVersionUID = 1L;
	private Account savings = new Account();
	private Account checking = new Account();
	private JButton withdrawB, depositB, transferToB, balanceB;
	private JRadioButton checkingRB, savingsRB;
	private JTextField dollarAmount;
	private int textFieldAmt;
	private NumberFormat numForm = NumberFormat.getCurrencyInstance();
	
	//Main program that calls the GUI 
	public static void main(String[] args) {
		new AutomatedTellerMachine();
	}
	
	//Code for the GUI, setting it up and calling necessary methods
	public AutomatedTellerMachine() {
		//setting up the basics of the window, formating text and button size
		this.setSize(400, 250);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("ATM Joe");
		Font theFont = new Font("serif", Font.BOLD, 0);
		Font biggerFont = theFont.deriveFont(18f);
		Dimension buttonDim = new Dimension(120,35);
		ListenForButton lButton = new ListenForButton();
		
		//Panel Creation
		JPanel thePanel = new JPanel();
		JPanel topBPanel = new JPanel();
		JPanel middleBPanel = new JPanel();
		
		//Layout Creation
		FlowLayout layoutSub1 = new FlowLayout(FlowLayout.CENTER, 20, 3);
		topBPanel.setLayout(layoutSub1);
		middleBPanel.setLayout(layoutSub1);
		
		//Button creation, customization and setting window layout
		withdrawB = new JButton("Withdraw");
		withdrawB.addActionListener(lButton);
		withdrawB.setPreferredSize(buttonDim);
		withdrawB.setFont(biggerFont);
		layoutSub1.addLayoutComponent("Withdraw Button", withdrawB);
		topBPanel.add(withdrawB);
		
		depositB = new JButton("Deposit");
		depositB.addActionListener(lButton);
		depositB.setPreferredSize(buttonDim);
		depositB.setFont(biggerFont);
		layoutSub1.addLayoutComponent("Deposit Button", depositB);
		topBPanel.add(depositB);
		
		transferToB = new JButton("Transfer to");
		transferToB.addActionListener(lButton);
		transferToB.setPreferredSize(buttonDim);
		transferToB.setFont(biggerFont);
		layoutSub1.addLayoutComponent("Transfer to Button", transferToB);
		middleBPanel.add(transferToB);
		
		balanceB = new JButton("Balance");
		balanceB.addActionListener(lButton);
		balanceB.setPreferredSize(buttonDim);
		balanceB.setFont(biggerFont);
		layoutSub1.addLayoutComponent("Balance Button", balanceB);
		middleBPanel.add(balanceB);
		
		//Radio Button creation and customization
		checkingRB = new JRadioButton("Checking");
		checkingRB.setFont(biggerFont);
		layoutSub1.addLayoutComponent("Checking Radio Button", checkingRB);
		savingsRB = new JRadioButton("Savings");
		savingsRB.setFont(biggerFont);
		layoutSub1.addLayoutComponent("Savings Radio Button", savingsRB);
		
		//ButtonGroup creation, adding RBs to group and then a panel for layout
		ButtonGroup accounts = new ButtonGroup();
		accounts.add(checkingRB);
		accounts.add(savingsRB);
		JPanel accountsPanel = new JPanel();
		Border accountsBorder =  BorderFactory.createTitledBorder("Accounts");
		accountsPanel.setLayout(layoutSub1);
		accountsPanel.setBorder(accountsBorder);
		accountsPanel.add(checkingRB);
		accountsPanel.add(savingsRB);
		//Set checking radio button to checked by default
		checkingRB.setSelected(true);
		
		//Text Field
		dollarAmount = new JTextField("", 8);
		dollarAmount.setFont(biggerFont);
		
		//Main Layout
		FlowLayout layoutMain = new FlowLayout(FlowLayout.CENTER, 200, 5);
		thePanel.setLayout(layoutMain);
		layoutMain.addLayoutComponent("Top Panel", topBPanel);
		layoutMain.addLayoutComponent("Middle Panel", middleBPanel);
		layoutMain.addLayoutComponent("Accounts Panel", accountsPanel);
		layoutMain.addLayoutComponent("Accounts Panel", dollarAmount);
		
		//Adding everything to the panel
		thePanel.add(topBPanel);
		thePanel.add(middleBPanel);
		thePanel.add(accountsPanel);
		thePanel.add(dollarAmount);
		this.add(thePanel);
		this.setVisible(true);
	}
	
	//Method to listen for button presses and performing actions and calling methods based on button and text field
	private class ListenForButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//try block identifies which button is clicked and which radio button is selected
			//thus determining what action will be performed.
			try {
				String money;
				//ensures textfield value is an integer IF balance isn't selected. balance doesn't need a textfield value to work
				if(e.getSource() != balanceB) {
					textFieldAmt = Integer.parseInt(dollarAmount.getText());
				}
				money = numForm.format(textFieldAmt);
				
				//if statement for Checking account and then determining which action to take and what method to call.
				if(checkingRB.isSelected()) {
					if(e.getSource() == withdrawB) {
						if(doWithdrawal(textFieldAmt, "checking")) {
							getWithdrawMsg(money, "checking");
						}
					} else if(e.getSource() == depositB) {
						checking.deposit((double)(textFieldAmt));
						getDepositMsg(money, "checking");

					} else if(e.getSource() == transferToB) {
						if(doWithdrawal(textFieldAmt, "savings")) {
							checking.deposit((double)(textFieldAmt));
							getTransferMsg(money, "savings", "checking");
						}

					} else if(e.getSource() == balanceB) {
						getBalanceMsg(checking.getAccountBalance(), "checking");
					}//end of checking radio button if
				//Savings radio button actions and method calls based on button click
				} else if (savingsRB.isSelected()) {
					if(e.getSource() == withdrawB) {
						if(doWithdrawal(textFieldAmt, "savings")) {
							getWithdrawMsg(money, "savings");
						}
					} else if(e.getSource() == depositB) {
						savings.deposit((double)(textFieldAmt));
						getDepositMsg(money, "savings");

					} else if(e.getSource() == transferToB) {
						if(doWithdrawal(textFieldAmt, "checking")) {
							savings.deposit((double)(textFieldAmt));
							getTransferMsg(money, "checking", "savings");
						}
							
					} else if(e.getSource() == balanceB) {
						getBalanceMsg(savings.getAccountBalance(), "savings");

					}
						
				}//end of savings radio button else if
			//catch statements for non-whole dollar values in increments of 20 as well as custom InsufficientFundsException	
			} catch(NumberFormatException except) {
				JOptionPane.showMessageDialog(null, "Please Enter a Dollar Amount in $20 Increments", "Error", JOptionPane.ERROR_MESSAGE);
				
			} catch (InsufficientFundsException e1) {
				JOptionPane.showMessageDialog(null, "Insufficient Funds to Complete Transacation", "Transaction Cancelled", JOptionPane.ERROR_MESSAGE);
			//finally block clears textfield and sets focus to textfield
			} finally {
				dollarAmount.setText("");
				dollarAmount.requestFocus();
			}
			
		}
		
	}
	//Transfers work by first executing doWithdrawal. If that is successful deposit is called to add the withdrawan value to the other account
	//withdrawal method, calls the withdrawal method in the Account class. Throws two exceptions if not enough funds or bad input
	public boolean doWithdrawal(int amount, String account) throws InsufficientFundsException, NumberFormatException {
		if(amount % 20 != 0) {
			throw new NumberFormatException();
		} else {
			if (account.equalsIgnoreCase("savings")) {
				if(savings.withdrawal(amount)) {
					return true;
				}	
			} else if(account.equalsIgnoreCase("checking")) {
				if(checking.withdrawal(textFieldAmt)) {
					return true;
				}
			}
			return false;
		}
		
	}
	
	//Methods for creating pop-up window messages after successful account activities
	public void getWithdrawMsg(String amount, String account) {
		if(Account.getWithdrawalNum() > 4) {
			JOptionPane.showMessageDialog(null, "Withdrawal of " + amount + 
					" from your " + account + " account successful. Service charge of " + Account.getServiceCharge() + " incurred.", "Withdawal Succesful", JOptionPane.INFORMATION_MESSAGE);
		} else {
		JOptionPane.showMessageDialog(null, "Withdrawal of " + amount + 
				" from your " + account + " account successful.", "Withdawal Succesful", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void getDepositMsg(String amount, String account) {
		JOptionPane.showMessageDialog(null, "Deposit of " + amount + 
				" to your " + account + " account successful.", "Deposit Succesful", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void getTransferMsg(String amount, String fromAccount, String toAccount) {
		if(Account.getWithdrawalNum() > 4) {
			JOptionPane.showMessageDialog(null, "Transfer of " + amount + " from your " + fromAccount + " account to your " + toAccount +
					" account successful. Service charge of " + Account.getServiceCharge() + " incurred.", "Transfer Succesful", 
					JOptionPane.INFORMATION_MESSAGE);
		} else {
		JOptionPane.showMessageDialog(null, "Transfer of " + amount + " from your " + fromAccount + " account to your " + 
				toAccount + " account successful.", "Transfer Succesful", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void getBalanceMsg(String amount, String account) {
		JOptionPane.showMessageDialog(null, "Your " + account + " account balance is: " +
				amount, "Account Balance", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
