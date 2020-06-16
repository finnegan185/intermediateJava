/* File: StudentDatabase.java
 * Author: Zachary Finnegan
 * Date 3/9/2019
 * Purpose: Project 4 of Intermediate Programming. Build a program that acts as a database for
 * students based on IDs, with associated names, majors and GPA. Utilizes the Student class,
 * hashmap and JFrame
 */

package ProjectFour;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class StudentDatabase extends JFrame {
	private static final long serialVersionUID = 1L;
	//all frame/panel components and hashmap to hold all students and IDs
	private static JLabel iDLabel, nameLabel, majorLabel, chooseLabel;
	private static JTextField iDText, nameText, majorText;
	private static JComboBox<Object> selectionBox;
	private static JButton daButton;
	private HashMap<String, Student> stuMap = new HashMap<String, Student>();
	
	public static void main(String[] args) {
		new StudentDatabase();
	}
	
	public StudentDatabase() {
		//frame and panel basics
		this.setSize(360, 260);
		this.setTitle("Project 4");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Font theFont = new Font("serif", Font.BOLD, 0);
		Font biggerFont = theFont.deriveFont(18f);
		
		//layout manager and panel creation
		GridBagLayout gBag = new GridBagLayout();
		JPanel thePanel = new JPanel();
		thePanel.setLayout(gBag);
		
		//JLabels 
		iDLabel = new JLabel("ID: ");
		nameLabel = new JLabel("Name: ");
		majorLabel = new JLabel("Major: ");
		chooseLabel = new JLabel("Choose Selection: ");
		iDLabel.setFont(biggerFont);
		nameLabel.setFont(biggerFont);
		majorLabel.setFont(biggerFont);
		chooseLabel.setFont(biggerFont);
		addComp(thePanel, iDLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(thePanel, nameLabel, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(thePanel, majorLabel, 0, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(thePanel, chooseLabel, 0, 3, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

		//JTextFields
		iDText = new JTextField("", 10);
		nameText = new JTextField("", 10);
		majorText = new JTextField("", 10);
		iDText.setFont(biggerFont);
		nameText.setFont(biggerFont);
		majorText.setFont(biggerFont);
		addComp(thePanel, iDText, 1, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		addComp(thePanel, nameText, 1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		addComp(thePanel, majorText, 1, 2, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

		//Combobox
		String[] items = {"", "Insert", "Delete", "Find", "Update", "Find All"};
		selectionBox = new JComboBox<Object>(items);
		selectionBox.setFont(biggerFont);
		BasicComboBoxRenderer rendy = new BasicComboBoxRenderer();
		rendy.setPreferredSize(new Dimension(127,22));
		selectionBox.setRenderer(rendy);
		addComp(thePanel, selectionBox, 1, 3, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);

		//JButton
		daButton = new JButton("Process Request");
		daButton.setFont(biggerFont);
		daButton.addActionListener(new ListenForButton());
		addComp(thePanel, daButton, 0, 4, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

		//add the panel to the frame, set enter to activate button
		this.add(thePanel);
		this.getRootPane().setDefaultButton(daButton);
		this.setVisible(true);
	}
	
	//button listener which initiates the combobox methods
	private class ListenForButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object cBoxPick = selectionBox.getSelectedItem();
			//first else if block incase of incomplete entries or findAll request
			if(cBoxPick.equals("")) {
				JOptionPane.showMessageDialog(null, "Please select an action.", "Error", JOptionPane.ERROR_MESSAGE);
			} else if(cBoxPick == "Find All") {
				getAllId();
			} else if(iDText.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please enter a Student's ID into the ID Text Box.", "Incomplete Entry", JOptionPane.ERROR_MESSAGE);
			} else {
				//if else to activate specific combobox methods
				String currentID = iDText.getText();
				if(cBoxPick == "Insert") {
					addStudent(iDText.getText(),nameText.getText(),majorText.getText());
				//checks to ensure input ID is in hashmap if yes activates combobox methods
				} else if (stuMap.containsKey(currentID)) {
					if(cBoxPick == "Delete") {
						deleteStudent(currentID);
					}else if(cBoxPick == "Find") {
						findStudent(currentID);
					}else if(cBoxPick == "Update") {
						updateStudent(currentID);
					}
				//If ID is not in hashmap call not found method
				} else {
					notFound(currentID);
				}
				clearTextFields();
			}
		}
		
	}
	
	//addstudent method, make sure input ID is unique and all textfields have values
	private void addStudent(String stuId, String stuName, String stuMajor) {
		if(stuId.isEmpty() || stuName.isEmpty() || stuMajor.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please ensure all text fields have values.", "Incomplete Entry", JOptionPane.ERROR_MESSAGE);
		} else {
			if(stuMap.containsKey(stuId)) {
				JOptionPane.showMessageDialog(null, "Duplicate ID, please enter a new unique ID.", "Insert Halted", JOptionPane.ERROR_MESSAGE);
			} else {
				stuMap.put(stuId, new Student(stuName, stuMajor));
				JOptionPane.showMessageDialog(null, "Student record creation successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
			}
		}	
	}
	
	//deletes student and notifies success
	private void deleteStudent(String stuId) {
		stuMap.remove(stuId);
		JOptionPane.showMessageDialog(null, "Student with ID: " + stuId + " has been successfully deleted.", "Student Deleted", JOptionPane.INFORMATION_MESSAGE);
	}
	
	//outputs input ID students information
	public void findStudent(String stuId) {
		Student tempStu = stuMap.get(stuId);
		JOptionPane.showMessageDialog(null, tempStu.toString(), "Student ID: " + stuId + " Found", JOptionPane.INFORMATION_MESSAGE);
	}
	
	//ensure input ID is present
	public void updateStudent(String stuId) {
		Student tempStu = stuMap.get(stuId);
		String grade = getGradeDialog();
		int credits = getCreditsDialog();
		tempStu.courseCompleted(grade, credits);
		JOptionPane.showMessageDialog(null, "Update Complete", "Success", JOptionPane.INFORMATION_MESSAGE);
	}
	
	//show ID not found dialog window
	public void notFound(String stuId) {
		JOptionPane.showMessageDialog(null, "Student with ID: " + stuId + " was not found. Please recheck the Student ID.", "Student ID Not Found", JOptionPane.ERROR_MESSAGE);
	}
	
	//method for populating and creating first update dialog with possible grades
	private String getGradeDialog() {
		Object[] grades = {"A","B","C","D","F"};
		String letter = (String)JOptionPane.showInputDialog(this, "Choose grade: ", "", JOptionPane.PLAIN_MESSAGE, null, grades, "A");
		return letter;
	}
	
	//method for populating and creating second update dialog with possible credit hours
	private int getCreditsDialog() {
		Object[] creditHours = {"2","3","4","6"};
		int credits = Integer.parseInt((String) JOptionPane.showInputDialog(this, "Choose credit grade: ", "", JOptionPane.PLAIN_MESSAGE, null, creditHours, "2"));
		return credits;
	}
	
	//clears all text fields and returns cursor to iDText field
	private void clearTextFields() {
		iDText.setText("");
		nameText.setText("");
		majorText.setText("");
		iDText.requestFocus();
	}
   
	//I had a hard time remembering all entered IDs so I added a findall ID method called getAllId
	public void getAllId() {
		Set<String> allStus = stuMap.keySet();
		if(allStus.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No students have been entered.", "Find All Failed", JOptionPane.INFORMATION_MESSAGE);
		} else {		
			JOptionPane.showMessageDialog(null, "Current Student IDs: " + allStus.toString(), "Find All", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//adds input components to the panel
	private void addComp(JPanel thePanel, JComponent comp, int xPos, int yPos, int compWidth, int compHeight, int place, int stretch){
    	
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
    
    
}
