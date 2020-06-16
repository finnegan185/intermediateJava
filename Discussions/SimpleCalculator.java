/* File: SimpleCalculator.java
 * Author: Zachary Finnegan
 * Date: 2/9/2019
 * Purpose: create a simple two value calculator with the basic arithmetic functions
 */

package Discussions;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class SimpleCalculator extends JFrame {
	//Fields for GUI objects and Account instance creation
	private static final long serialVersionUID = 1L;
	private JButton addB, subtractB, multiplyB, divideB, powerB, remainderB;
	private JTextField firstNumF, secondNumF, resultF;
	private double firstNum, secondNum, result;
	
	//Main program that calls the GUI 
	public static void main(String[] args) {
		new SimpleCalculator();
	}

	//Code for the GUI, setting it up and calling necessary methods
	public SimpleCalculator() {
		//setting up the basics of the window, formating text and button size
		this.setSize(550, 120);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Simple Calculator");
		ListenForButton lButton = new ListenForButton();
		
		JPanel thePanel = new JPanel();
		
		JLabel firstLabel = new JLabel("First Number");
		thePanel.add(firstLabel);
		firstNumF = new JTextField("", 8);
		thePanel.add(firstNumF);
		JLabel secondLabel = new JLabel("Second Number");
		thePanel.add(secondLabel);
		secondNumF = new JTextField("", 8);
		thePanel.add(secondNumF);
		JLabel resultLabel = new JLabel("Result");
		thePanel.add(resultLabel);
		resultF = new JTextField("", 8);
		resultF.setEditable(false);
		thePanel.add(resultF);
		
		addB = new JButton("Add");
		addB.addActionListener(lButton);
		thePanel.add(addB);
		subtractB = new JButton("Subtract");
		subtractB.addActionListener(lButton);
		thePanel.add(subtractB);
		multiplyB = new JButton("Multiply");
		multiplyB.addActionListener(lButton);
		thePanel.add(multiplyB);
		divideB = new JButton("Divide");
		divideB.addActionListener(lButton);
		thePanel.add(divideB);
		powerB = new JButton("Power");
		powerB.addActionListener(lButton);
		thePanel.add(powerB);
		remainderB = new JButton("Remainder");
		remainderB.addActionListener(lButton);
		thePanel.add(remainderB);
		
		this.add(thePanel);
		this.setVisible(true);
		
		
	}
	private class ListenForButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				firstNum = Double.parseDouble(firstNumF.getText());
				secondNum = Double.parseDouble(secondNumF.getText());
				if(e.getSource() == addB) {
					result = firstNum + secondNum;
				} else if(e.getSource() == subtractB) {
					result = firstNum - secondNum;
				} else if(e.getSource() == multiplyB) {
					result = firstNum * secondNum;
				} else if(e.getSource() == divideB) {
					result = firstNum / secondNum;
				} else if(e.getSource() == powerB) {
					result = Math.pow(firstNum, secondNum);
				} else if(e.getSource() == remainderB) {
					result = firstNum % secondNum;
				}
				resultF.setText(Double.toString(result));
				
			}catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Please Enter a Number.", "Not A Usable Number", JOptionPane.ERROR_MESSAGE);

			}finally {
				firstNumF.setText("");
				secondNumF.setText("");
				firstNumF.requestFocus();
			}
		}
	}
}
