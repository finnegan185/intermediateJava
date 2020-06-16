package Discussions;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class GCD extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField inputA, inputB, output, efficiency;
	private JRadioButton iterativeRB, recursiveRB, mehRB;
	private JButton computeB;
	private JLabel inAL, inBL, outL, efficL;
	int iterCount, recurCount, mehCount;
	
	public static void main(String[] args) {
		new GCD();
	}

	public GCD() {
		this.setSize(250,300);
		this.setLocationRelativeTo(null);
		this.setTitle("Computation Window");
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
		mehRB = new JRadioButton("Efficient Iteration");
		mehRB.addActionListener(this);
		ButtonGroup rbGroup = new ButtonGroup();
		rbGroup.add(iterativeRB);
		rbGroup.add(recursiveRB);
		rbGroup.add(mehRB);
		rbBox.add(iterativeRB);
		rbBox.add(recursiveRB);
		rbBox.add(mehRB);
		rbBox.setBorder(BorderFactory.createEmptyBorder());
		addComp(thePanel, rbBox, 2, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		
		//Input
		inAL = new JLabel("Enter a:");
		inputA = new JTextField("", 7);
		inputA.requestFocus();
		addComp(thePanel, inAL, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(thePanel, inputA, 2, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		inBL = new JLabel("Enter b:");
		inputB = new JTextField("", 7);
		addComp(thePanel, inBL, 0, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(thePanel, inputB, 2, 2, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		
		//Compute
		computeB = new JButton("Compute");
		computeB.addActionListener(this);
		addComp(thePanel, computeB, 2, 3, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

		//Output
		outL = new JLabel("Result:");
		output = new JTextField("", 7);
		output.setEditable(false);
		output.setBackground(Color.WHITE);
		addComp(thePanel, outL, 0, 4, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(thePanel, output, 2, 4, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

		//Efficiency
		efficL = new JLabel("Efficiency");
		efficiency = new JTextField("", 7);
		efficiency.setEditable(false);
		efficiency.setBackground(Color.WHITE);
		addComp(thePanel, efficL, 0, 5, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(thePanel, efficiency, 2, 5, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
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
					result = firstGCDMethod(Integer.parseInt(inputA.getText()), Integer.parseInt(inputB.getText()));
					efficValue = getEfficiency(1);
				} else if (recursiveRB.isSelected()){
					recurCount = 0;
					result = recursionGCDMethod(Integer.parseInt(inputA.getText()), Integer.parseInt(inputB.getText()));;
					efficValue = getEfficiency(2);
				} else {
					mehCount = 0;
					result = secondGCDMethod(Integer.parseInt(inputA.getText()), Integer.parseInt(inputB.getText()));;
					efficValue = getEfficiency(3);
				}
				output.setText(String.valueOf(result));
				efficiency.setText(String.valueOf(efficValue));	
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "Please enter a positive integer.", "Incorrect Input", JOptionPane.ERROR_MESSAGE);
				inputA.setText("");
			}
		} else if (e.getSource() != computeB) {
			output.setText("");
			efficiency.setText("");
		}
	}
	
	private int firstGCDMethod(int a, int b) {
		iterCount = 0;
		while(a != b) {
			if(a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
			iterCount++;
		}
		return a;
	}
	
	private int secondGCDMethod(int a, int b) {
		while(b > 0) {
			int r = a % b;
			a = b;
			b = r;
			mehCount++;
		}
		return a;
	}
	
	private int recursionGCDMethod(int a, int b) {
		if(b == 0) {
			return a;
		} else {
			int k = Math.max(a, b);
			int m = Math.min(a, b);
			int r = k % m;
			recurCount++;
			return recursionGCDMethod(b, r);
		}
	}


	public int getEfficiency(int type) {
		if(type == 1) {
			return iterCount;
		} else if (type == 2) {
			return recurCount;
		} else {
			return mehCount;
		}
	}
}
