/* File: SimpleGUI.java
 * Author: Zachary Finnegan
 * Date: 2/9/2019
 * Purpose: create a simple GUI where one integer value is entered a button is pressed and the output
 * message explaining how crazy that number is is put in the second text field.
 */

package Discussions;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGUI extends JFrame implements ActionListener
{
   private JButton okButton = new JButton("OK");

   public SimpleGUI()
   {
       add(okButton);
       okButton.addActionListener(this);
   }

   public void actionPerformed(ActionEvent e)
   {
       System.out.println("The OK button is clicked");
   }

   public static void main(String[] args)
   {
       JFrame frame = new SimpleGUI();
       frame.setSize(300, 300);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
   }
}