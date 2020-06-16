package stuff;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FtoC extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JTextField fText, cText, qtText, bpmText, qTcText;
	JButton calculate, qtcButton;
	public static void main(String[] args){
		new FtoC();
		
	}
	public FtoC() {
		this.setSize(200,300);
		this.setTitle("Temp Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		JLabel fLabel = new JLabel("Fahrenheit:      ");
		fText = new JTextField("", 6);
		JLabel cLabel = new JLabel("Celsius:   ");
		cText = new JTextField("", 6);
		cText.setEditable(false);
		calculate = new JButton("F to C");
		calculate.addActionListener(this);
		this.rootPane.setDefaultButton(calculate);
		JPanel thePanel = new JPanel();
		thePanel.setLayout(new GridBagLayout());
		JPanel cPanel = new JPanel();
		addComp(thePanel, fLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(thePanel, fText, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(thePanel, cLabel, 1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(thePanel, cText, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		cPanel.add(calculate);
		qtText = new JTextField("", 6);
		bpmText = new JTextField("", 6);
		qTcText = new JTextField("", 6);
		qTcText.setEditable(false);
		JLabel qtLabel = new JLabel("QT:");
		JLabel bpmLabel = new JLabel("BPM:");
		JLabel qtFLabel = new JLabel("QTcF;");
		qtcButton = new JButton("QTcF");
		qtcButton.addActionListener(this);
		JPanel qtInputPanel = new JPanel();
		qtInputPanel.setLayout(new GridBagLayout());
		addComp(qtInputPanel, qtLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(qtInputPanel, qtText, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(qtInputPanel, bpmLabel, 1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(qtInputPanel, bpmText, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(qtInputPanel, qtcButton, 0, 3, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(qtInputPanel, qtFLabel, 1, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(qtInputPanel, qTcText, 1, 3, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		this.setLayout(new FlowLayout());
		this.add(thePanel);
		this.add(cPanel);
		this.add(qtInputPanel);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		NumberFormat twoDeci = new DecimalFormat("#0.00");
		if(e.getSource() == calculate) {
			try {
				double cNum = (Double.parseDouble(fText.getText())-32)*(5.0/9);	
				String output = twoDeci.format(cNum);
				cText.setText(output);
			} catch (NumberFormatException e1) {
				
			}
		} else if (e.getSource() == qtcButton) {
			try {
				double qtNum = Double.parseDouble(qtText.getText());
				double bpmNum = Double.parseDouble(bpmText.getText());
				if(qtNum < 1 || bpmNum < 1) {
					throw new NumberFormatException();
				}
				double rrNum = 60 / bpmNum;
				double qtCNum = qtNum / (Math.cbrt(rrNum));
				qTcText.setText(twoDeci.format(qtCNum));
			} catch (NumberFormatException e2) {
				
			}
		}
			
	}
	
	private void addComp(JPanel thePanel, JComponent comp, int xPos, int yPos, int compWidth, int compHeight, int anchor, int stretch) {
		GridBagConstraints gBag = new GridBagConstraints();
		gBag.gridx = xPos;
		gBag.gridy = yPos;
		gBag.gridwidth = compWidth;
		gBag.gridheight = compHeight;
		gBag.insets = new Insets(5,5,5,5);
		gBag.weightx = 100;
		gBag.weighty = 100;
		gBag.anchor = anchor;
		gBag.fill = stretch;
		
		thePanel.add(comp, gBag);
		
	}
}
