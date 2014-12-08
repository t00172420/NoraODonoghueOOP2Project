//Patient.java
/*This program creates a patient object which allows a user to enter details to book an appointment
 *this program allows uses similar code from person.java by John Walsh*/
import java.io.*;

public class Patient implements Serializable{
	private String pName;
	private int pAge;
	private int pNumber;


public Patient(){
	this("No name",0,0);
}
public String getPName() {return pName;}
public int getPAge() { return pAge;}
public int getPNumber() { return pNumber;}


public Patient(String pName, int pAge, int pNumber){
	setPName(pName);
	setPAge(pAge);
	setPNumber(pNumber);
}
public void setPName(String pName) {
	this.pName = pName;
}
public void setPAge(int pAge){
	this.pAge = pAge;
}
public void setPNumber(int pNumber) {
	this.pNumber = pNumber;
}

public String toString() {
				return getPName() + " " + getPAge() + " " + getPNumber() + " ";
	}
}