//Appoint.java
/*This program sets the doctors appointment frame and uses code from the Sample Programs from
 *John Walsh and the bicycle frame program*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;  
/** manages an array of appointments, including saving and loading */
public class Appoint extends JFrame implements ActionListener{
    
     JMenu fileMenu,AppointMenu;
     Appoint [] appoints; // an array of appointments
     int count; 
     
    // driver 
    public static void main( String[] args ) {
        Appoint frame = new Appoint();
        frame.setVisible(true);
    }
    
    // constructor
    public Appoint( ) {
        newSystem();
        //set the frame default properties
        setTitle     ( "Doctors Appointment system" );
        setSize      ( 500,300 );
        setLocation  ( 200,200 );
        Container pane = getContentPane();
        pane.setBackground(new Color(pink));
        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        
        createFileMenu();
        createAppointMenu();
        //and add them to the menubar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(AppointMenu);
     }     
    
      public void newSystem() {
      	appoints = new Appoint[10];
      	count = 0;
      }
      
      /** writes the array of appointments to the file "appoint.dat"
       */   // NEW
      public void save() throws IOException {
      	ObjectOutputStream os;
      	os = new ObjectOutputStream(new FileOutputStream ("appoint.dat"));
      	os.writeObject(appoints);
      	os.close();
      }
      
      /** loads an array of appointments from the file "appoints.dat"
       */  // NEW
      public void open() {
      	count = 0;
      	try{
      	  ObjectInputStream is;
      	  is = new ObjectInputStream(new FileInputStream ("appoint.dat"));
         	appoints  = (Appoint []) is.readObject();
      	  is.close(); 
      	}
      	catch(Exception e){
      		JOptionPane.showMessageDialog(null,"open didn't work");
      		e.printStackTrace();
      	}
      	
      	// how many valid appointment records?
      	while (appoints[count] !=null)
      	   count++;
      } // end open()
      
     
      public void addAppoint(){
      	Appoint app = new Appoint();
      	app.setPName(JOptionPane.showInputDialog("Enter your name: "));
      	Appoint[count] = app;
      	// set the attributes: ask the user for patient name etc
      	count++; // now there is one more appointment in the system
      }
      
      public void display(){
      	JTextArea area = new JTextArea();
      	if (count>0) {
      	  area.setText("Appointment List: needs better output formatting\n\n");
      	  for (int i = 0; i<count; i++) // loop over existing appointments, rather than array size
      	    area.append("Appointment no: " + i + " " +appoints[i].toString()+"\n");
      	  showMessage(area);
      	}
      	else
      	    showMessage("No Appointments in the system");
      } // end display
      
      public void actionPerformed (ActionEvent e) {
      	if (e.getActionCommand() .equals ("Quit")){
      	 showMessage("Shutting down the system");
      	 System.exit(0);
      	}
      	else if (e.getActionCommand() .equals ("Add")){
      	   addAppoint(); // branch to a separate method
      	}
      	else if (e.getActionCommand() .equals ("Display")){
           display();
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
      
      private void createBikeMenu(){
      	// create the menu
      	AppointMenu = new JMenu("Appointment");
      	// declare a menu item (re-usable)
      	JMenuItem item;
      	
      	item = new JMenuItem("Add");
      	item.addActionListener(this);
      	AppointMenu.add(item);
      	
      	item = new JMenuItem("Display");
      	item.addActionListener(this);
      	AppointMenu.add(item);
      }
       /** utility methods to make the code simpler */
      public void showMessage (String s){
      	JOptionPane.showMessageDialog(null,s);
      }
      
      public void showMessage (JTextArea s){
      	JOptionPane.showMessageDialog(null,s);
      }
}