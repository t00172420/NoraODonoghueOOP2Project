//Patient.java
/*This program creates a patient object which allows a user to enter details to book an appointment*/
import java.io.*;

public class Patient implements Serializable{
	private String pName;
	private int pAge;
	private int pNumber;
	private char gender;

public Patient(){
	this("No name",0,0,'N');
}
public String getPName() {return pName;}
public int getPAge() { return pAge;}
public int getPNumber() { return pNumber;}
public char getGender() { return gender;}

public Patient(String pName, int pAge, int pNumber, char gender){
	setPName(pName);
	setPAge(pAge);
	setPNumber(pNumber);
	setGender(gender);
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
public void setGender(char gender) {
	this.gender = gender;
}
public String toString() {
				return getPName() + " " + getPAge() + " " + getPNumber + " " + getGender();
	}
}