//AppointmentDoctors.java
//Nora O'Donoghue
/*Sample code taken from myBicycleFrame in John Walsh Sample Programs*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class AppointmentDoctors extends JFrame implements ActionListener{
	
	 private JLabel DoctorLabel;
	 private JButton ExitButton;
	 JMenu fileMenu,appointMenu;
     Appointment [] appoints; // an array of appointments
     int count;
     
     public static void main( String[] args ) {
        AppointmentDoctors doc = new AppointmentDoctors();
        doc.setVisible(true);
     }   
        // constructor
    	public AppointmentDoctors() {
        newSystem();
        //set the frame default properties
        setTitle     ( "Book Doctors Appointment");
        setSize      ( 400,400 );
        setLocation  ( 200,200 );
        Container pane = getContentPane();
      //  pane.setBackground(Color.pink);
        pane.setBackground(Color.pink);
        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        //creates a JButton on welcome page to exit 
        /*modified*/
        ExitButton = new JButton("Exit");
        ExitButton.addActionListener(this);
        ExitButton.setVisible(true);
        pane.add(ExitButton);
      //creates JLabel on welcome page
      /*modified*/
        DoctorLabel = new JLabel("Island Clinic");
        pane.add(DoctorLabel);
       
         
        createFileMenu();
        createAppointMenu();
        //and add them to the menubar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(appointMenu);
     }     
    
      public void newSystem() {
      	appoints = new Appointment[10];
      	count = 0;
      }
      
      // writes the array of appointment to the file "appoints.dat"
      
      public void save() throws IOException {
      	ObjectOutputStream os;
      	os = new ObjectOutputStream(new FileOutputStream ("appoints.dat"));
      	os.writeObject(appoints);
      	os.close();
      }
      
      // loads an array of appointments from the file "appoints.dat"
       
      public void open() {
      	count = 0;
      	try{
      	  ObjectInputStream is;
      	  is = new ObjectInputStream(new FileInputStream ("appoints.dat"));
         	appoints  = (Appointment []) is.readObject();
      	  is.close(); 
      	}
      	catch(Exception e){
      		JOptionPane.showMessageDialog(null,"open didn't work");
      		e.printStackTrace();
      	}
      	
      	// how many valid appointments records?
      	while (appoints[count] !=null)
      	   count++;
      } // end open()
      
     
      public void addAppointment(){
      	Appointment temp = new Appointment();
      	temp.setDName(JOptionPane.showInputDialog("Which doctor do you wish to book appointment with?"));
      	temp.setDate(Integer.parseInt(JOptionPane.showInputDialog("What date?")));
      	temp.setTime(Integer.parseInt(JOptionPane.showInputDialog("What time?")));
      	appoints[count] = temp; // 'default appointment
      	// set the attributes: ask the user for doctor name etc
      	count++; // now there is one more appointment in the system
      }
 
      
      public void display(){
      	JTextArea area = new JTextArea();
      	if (count>0) {
      	  area.setText("Appointment List: \n\n");
      	  for (int i = 0; i<count; i++) // loop over existing appointments, rather than array size
      	    area.append("Appointment no: " + i + " " +appoints[i].toString()+"\n");
      	  showMessage(area);
      	}
      	else
      	    showMessage("No appointments in the system");
      } // end display
      
      public void actionPerformed (ActionEvent e) {
      	if (e.getActionCommand() .equals ("Quit")){
      	 showMessage("Shutting down the system");
      	 System.exit(0);
      	}
      	else if (e.getActionCommand() .equals ("Book Appointment")){
      	   addAppointment(); // branch to a separate method
      	}
      	else if (e.getActionCommand() .equals ("Display")){
           display();
      	}
      	else if (e.getActionCommand() .equals("Exit")){
      		System.exit(0);
      	}
      	else if (e.getActionCommand() .equals ("New File")){
      		newSystem();
        }
      	else if (e.getActionCommand() .equals ("Save")){
      	// NEW BLOCK OF ERROR-HANDLING HERE: MUST BE INCLUDED
      	 try{
      	 	save();
      	 	showMessage("Data saved successfully");
      	 } // try
      	 catch (IOException f){
      	 	showMessage("Not able to save the file:\n"+
      	 	"Check the console printout for clues to why ");
      	 	f.printStackTrace();
      	 }// catch
      	}// else if
      	
      	else if (e.getActionCommand() .equals ("Open")){
      	 open();
         display();
      	}
      	else
      	  showMessage("I have no idea what you clicked");
      } // actionPerformed
      
        private void createFileMenu(){
         // create the menu
      	fileMenu = new JMenu("File");
      	// declare a menu item (re-usable)
      	JMenuItem item;
      	item = new JMenuItem("Save");
      	item.addActionListener(this);
      	fileMenu.add(item);
      	item = new JMenuItem("Open");
      	item.addActionListener(this);
      	fileMenu.add(item);
      	item = new JMenuItem("New File");
      	item.addActionListener(this);
      	fileMenu.add(item);
      	// create the 'quit' option
      	fileMenu.addSeparator();
      	item = new JMenuItem("Quit");
      	item.addActionListener(this);
      	fileMenu.add(item);
      }
      
      private void createAppointMenu(){
      	// create the menu
      	appointMenu = new JMenu("Appointment");
      	// declare a menu item (re-usable)
      	JMenuItem item;
      	
      	item = new JMenuItem("Book Appointment");
      	item.addActionListener(this);
      	appointMenu.add(item);
      	      	
      	item = new JMenuItem("Display");
      	item.addActionListener(this);
      	appointMenu.add(item);
      }
       /** utility methods to make the code simpler */
      public void showMessage (String s){
      	JOptionPane.showMessageDialog(null,s);
      }
      
      public void showMessage (JTextArea s){
      	JOptionPane.showMessageDialog(null,s);
      
    }
}

