//DoctorsAppoint.java
/*This program allows a user to choose a day from an array list and enter details into the array
 *to book a Doctors Appointment and return the details entered back to the user*/

import javax.swing.*;

public class DoctorsAppoint {
	public static void main (String args[]){

		String pName;
		int pNumber;
		
		String [] day = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
		JList dayList = new JList(day);
	    JOptionPane.showMessageDialog(null,dayList,"Choose your day", JOptionPane.PLAIN_MESSAGE);
	   
	    int dayNum = dayList.getSelectedIndex();	       	
		String [] time = {"09:00", "10:00", "11:00", "12:00", "14:00", "15:00", "16:00", "17:00"};
	
		JList timeList = new JList(time);
	    JOptionPane.showMessageDialog(null,timeList,"Choose your time", JOptionPane.PLAIN_MESSAGE);
	    
	    String [] dName = {" Dr.Anita McCarthy "," Dr.Simon Jones "," Dr.Calvin O'Connor "," Dr.Maria Murphy "};
	    JList dNameList = new JList(dName);
	    JOptionPane.showMessageDialog(null,dNameList,"Choose your doctor", JOptionPane.PLAIN_MESSAGE);
	    
	    pName = JOptionPane.showInputDialog("Please enter your name: ");
	    pNumber = Integer.parseInt(JOptionPane.showInputDialog("Please enter your contact number: "));
	    int timeNum = timeList.getSelectedIndex();
	    	     
	    JOptionPane.showMessageDialog(null,"Book Appointment for " + dayList.getSelectedValue() + " at " + timeList.getSelectedValue() + " with " + dNameList.getSelectedValue());	
	}
}