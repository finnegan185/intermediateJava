/* File: RecursionGUI.java
 * Author: Zachary Finnegan
 * Date 2/20/2019
 * Purpose: Create a GUI that uses user input to compare the efficiency between 
 * recursion and iteration in computing from the Computation.java file. When the 
 * window is closed the program executes a file writer method that creates a file
 * where the program will write the efficiency values per computation method from 
 * n values 0-10
 */

package projectThree;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class RecursionGUI extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JTextField input, output, efficiency;
	private JRadioButton iterativeRB, recursiveRB;
	private JButton computeB;
	private JLabel inL, outL, efficL;
	
	public static void main(String[] args) {
		new RecursionGUI();
	}

	public RecursionGUI() {
		this.setSize(250,250);
		this.setLocationRelativeTo(null);
		this.setTitle("Computation Window");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				fileWriter();
			}
		});
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel thePanel = new JPanel();
		thePanel.setLayout(new GridBagLayout());
		
		//RadioButtons
		Box rbBox = Box.createVerticalBox();
		iterativeRB = new JRadioButton("Iteration");
		iterativeRB.setSelected(true);
		iterativeRB.addActionListener(this);
		recursiveRB = new JRadioButton("Recursion");
		recursiveRB.addActionListener(this);
		ButtonGroup rbGroup = new ButtonGroup();
		rbGroup.add(iterativeRB);
		rbGroup.add(recursiveRB);
		rbBox.add(iterativeRB);
		rbBox.add(recursiveRB);
		rbBox.setBorder(BorderFactory.createEmptyBorder());
		addComp(thePanel, rbBox, 2, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		
		//Input
		inL = new JLabel("Enter n:");
		input = new JTextField("", 7);
		input.requestFocus();
		addComp(thePanel, inL, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(thePanel, input, 2, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		
		//Compute
		computeB = new JButton("Compute");
		computeB.addActionListener(this);
		addComp(thePanel, computeB, 2, 2, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

		//Output
		outL = new JLabel("Result:");
		output = new JTextField("", 7);
		output.setEditable(false);
		output.setBackground(Color.WHITE);
		addComp(thePanel, outL, 0, 3, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(thePanel, output, 2, 3, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

		//Efficiency
		efficL = new JLabel("Efficiency");
		efficiency = new JTextField("", 7);
		efficiency.setEditable(false);
		efficiency.setBackground(Color.WHITE);
		addComp(thePanel, efficL, 0, 4, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(thePanel, efficiency, 2, 4, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

		this.add(thePanel);
		this.setVisible(true);
		
	}
	
	private void addComp(JPanel thePanel, JComponent comp, int xPos, int yPos, int compWidth, int compHeight, int place, int stretch) {
        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = xPos;
        gridConstraints.gridy = yPos;
        gridConstraints.gridwidth = compWidth;
        gridConstraints.gridheight = compHeight;
        gridConstraints.weightx = 100;
        gridConstraints.weighty = 100;
        gridConstraints.insets = new Insets(5,5,5,5);
        gridConstraints.anchor = place;
        gridConstraints.fill = stretch;

        thePanel.add(comp, gridConstraints);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == computeB) {
			try{
				int result;
				int efficValue;
				if (iterativeRB.isSelected()) {
					result = Computation.computeIterative(Integer.parseInt(input.getText()));
					efficValue = Computation.getEfficiency(true);
				} else {
					result = Computation.computeRecursion(Integer.parseInt(input.getText()));
					efficValue = Computation.getEfficiency(false);
				}
				output.setText(String.valueOf(result));
				efficiency.setText(String.valueOf(efficValue));	
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "Please enter a positive integer.", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
				input.setText("");
			}
		} else if (e.getSource() == iterativeRB || e.getSource() == recursiveRB) {
			input.setText("");
			output.setText("");
			efficiency.setText("");
		}
	}
	
	public void fileWriter() {
		BufferedWriter writer = null;
		try {
			File computationFile = new File("ComputationEfficiency.csv");
			if(!computationFile.exists()) {
				computationFile.createNewFile();
			}
			writer = new BufferedWriter(new FileWriter(computationFile));
			writer.write("n,Iteration,Recursion\n");
			for(int i = 0; i <= 10; i++) {
				int iterEff = Computation.getEfficiency(true, i);
				int recurEff = Computation.getEfficiency(false, i);
				String toWrite = i + "," + iterEff + "," + recurEff + "\n";
				writer.write(toWrite);
			} 
			writer.close();
			
		} catch (FileNotFoundException e1) {
				System.out.println(e1.getMessage());
		} catch (IOException e2) {
			System.out.println(e2.getMessage());
		}
	}

}
