package stuff;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class InterestCalculator extends JFrame{
	private JLabel initialL, totalL, interestL, yearsL, monthlyL;
	private JTextField initialF, totalF, interestF, yearsF, monthlyF;
	private JRadioButton daily, monthly, yearly;
	private JButton calculateB;
	private ButtonGroup bGroup;
	
	public static void main(String[] args) {
		new InterestCalculator();
	}

	public InterestCalculator() {
		// basic frame setup
		this.setTitle("Interest Calculator");
		this.setSize(400, 350);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//labels
		initialL = new JLabel("Initial Balance:        ");
		totalL = new JLabel("Ending Balance:    ");
		interestL = new JLabel("Interest Rate (percent):         ");
		yearsL = new JLabel("Saving Length (years):           ");
		monthlyL = new JLabel("Monthly Deposit:   ");
		
		//textfields
		initialF = new JTextField("", 10);
		initialF.requestFocus();
		totalF = new JTextField("", 10);
		totalF.setEditable(false);
		interestF = new JTextField("", 5);
		yearsF = new JTextField("", 5);
		monthlyF = new JTextField("", 10);
		
		//buttons
		daily = new JRadioButton("Daily");
		monthly = new JRadioButton("Monthly");
		yearly = new JRadioButton("Yearly");
		bGroup = new ButtonGroup();
		bGroup.add(daily);
		bGroup.add(monthly);
		bGroup.add(yearly);
		calculateB = new JButton("Calculate");
		ListenForButton listen = new ListenForButton();
		calculateB.addActionListener(listen);
		
		//panels
		GridBagLayout gridy = new GridBagLayout();
		JPanel thePanel = new JPanel();
		thePanel.setLayout(gridy);
		JPanel initialPanel = new JPanel();
		initialPanel.setLayout(gridy);
		JPanel totalPanel = new JPanel();
		totalPanel.setLayout(gridy);
		JPanel interestPanel = new JPanel();
		interestPanel.setLayout(gridy);
		JPanel yearPanel = new JPanel();
		yearPanel.setLayout(gridy);
		JPanel monthPanel = new JPanel();
		monthPanel.setLayout(gridy);
		JPanel rbPanel = new JPanel();
		rbPanel.setLayout(gridy);
		rbPanel.setBorder(BorderFactory.createTitledBorder("Compound Rate"));
		
		
		addComp(initialPanel, initialL, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		addComp(initialPanel, initialF, 1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		
		addComp(totalPanel, totalL, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		addComp(totalPanel, totalF, 1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		
		addComp(interestPanel, interestL, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		addComp(interestPanel, interestF, 1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		
		addComp(yearPanel, yearsL, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		addComp(yearPanel, yearsF, 1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		
		addComp(monthPanel, monthlyL, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		addComp(monthPanel, monthlyF, 1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		
		addComp(rbPanel, daily, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(rbPanel, monthly, 1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(rbPanel, yearly, 2, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		
		addComp(thePanel, initialPanel, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		addComp(thePanel, interestPanel, 0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		addComp(thePanel, rbPanel, 0, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		addComp(thePanel, yearPanel, 0, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		addComp(thePanel, monthPanel, 0, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		addComp(thePanel, calculateB, 0, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		addComp(thePanel, totalPanel, 0, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);

		this.add(thePanel);
		this.setVisible(true);
		
	}
	
	private class ListenForButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			totalF.setText("");
			if(!initialF.getText().isEmpty() && !yearsF.getText().isEmpty() && !monthlyF.getText().isEmpty() && !interestF.getText().isEmpty()) {
				try {
					double initialNum = Double.parseDouble(initialF.getText());
					double yearsNum = Double.parseDouble(yearsF.getText());
					double monthsNum = Double.parseDouble(monthlyF.getText());
					double interestNum = Double.parseDouble(interestF.getText())/100;
					System.out.println("Interest: " + interestNum + " Months: " + monthsNum + " Years: " + yearsNum + " Balance: " + initialNum);
					double total = 0;
					
					if(daily.isSelected()) {
						total = (initialNum*(Math.pow(1+(interestNum/365),(yearsNum*365))));
						total += monthsNum*(((Math.pow((1+(interestNum/365)), (yearsNum*365))-1)/(interestNum/365))*(1+(interestNum/365)));
					} else if(monthly.isSelected()) {
						total = (initialNum*(Math.pow(1+(interestNum/12),(yearsNum*12))));
						System.out.println(total);
						total -= monthsNum*(((Math.pow((1+(interestNum/12)), (yearsNum*12))-1)/(interestNum/12))*(1+(interestNum/12)));
					} else if(yearly.isSelected()) {
						total = (initialNum*(Math.pow(1+(interestNum/1),(yearsNum*1))));
						total += monthsNum*(((Math.pow((1+(interestNum/1)), (yearsNum*1))-1)/(interestNum/1))*(1+(interestNum/1)));
					} else {
						JOptionPane.showMessageDialog(null, "Please select a compound rate.", "Incomplete", JOptionPane.ERROR_MESSAGE);
					}
					System.out.print(total);
					DecimalFormat dMat = new DecimalFormat("#,###,##0.00");
					totalF.setText(dMat.format(total));
					
				}catch(NumberFormatException e1) {
					
					JOptionPane.showMessageDialog(null, "Please enter a number in all text fields.", "Incomplete", JOptionPane.ERROR_MESSAGE);

				}
			} else {
				JOptionPane.showMessageDialog(null, "Please fill in all text fields.", "Incomplete", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	
	private void addComp(JPanel thePanel, JComponent comp, int xPos, int yPos, int compWidth, int compHeight,
			int anchor, int stretch) {
		GridBagConstraints gBag = new GridBagConstraints();
		gBag.gridx = xPos;
		gBag.gridy = yPos;
		gBag.gridwidth = compWidth;
		gBag.gridheight = compHeight;
		gBag.insets = new Insets(5, 5, 5, 5);
		gBag.weightx = 100;
		gBag.weighty = 100;
		gBag.anchor = anchor;
		gBag.fill = stretch;

		thePanel.add(comp, gBag);

	}
}
