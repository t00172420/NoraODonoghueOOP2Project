//Appointment.java
/*This program creates an appointment object which allows a user to enter details to book an appointment*/
import java.io.*;

public class Appointment implements Serializable{
	private String dName;
	private int date;
	private int time;

public Appointment(){
	this("No name",0,0);
}
public String getDName() {return dName;}
public int getDate() { return date;}
public int getTime() { return time;}

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

public String toString() {
				return getDName() + " " + getDate() + " " + getTime() + " " ;
	}
}