//Appointment.java
/*This program creates an appointment object which allows a user to enter details to book an appointment*/
import java.io.*;

public class Appointment implements Serializable{
	private String dName;
	private int date;
	private int time;
/** single argument constructor method
	 @param name the full name of the appointment */

public Appointment(){
	this("No name",0,0);
}
/** acessor method to return the appointment name, date and time
	 *@return the name, date and time of the student */

public String getDName() {return dName;}
public int getDate() { return date;}
public int getTime() { return time;}
/** mutator method to set the appointment name
	 *@param name the name of the patient */

public Appointment(String dName, int date, int time){
	setDName(dName);
	setDate(date);
	setTime(time);
}
public void setDName(String dName) {
	this.dName = dName;
}
public void setDate(int date){
	this.date = date;
}
public void setTime(int time) {
	this.time = time;
}
/** toString method to return the appointment details
	 *@return the name and date and age of the appointment as a string */

public String toString() {
				return getDName() + " " + getDate() + " " + getTime() + " " ;
	}
}