package jpa.entity.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private String sEmail;
	private String sName;
	private String sPass; 
	private List sCourses;
	
	
	public Student() {
		sEmail = null;
		sName = null;
		sPass = null;
		sCourses = null; 
		
		
	}
	
	
	public Student(String sEmail, String sName, String sPass, List sCourses) {
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPass = sPass;
		this.sCourses = sCourses;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsPass() {
		return sPass;
	}
	public void setsPass(String sPass) {
		this.sPass = sPass;
	}
	public List getsCourses() {
		return sCourses;
	}
	public void setsCourses(List sCourses) {
		this.sCourses = sCourses;
	} 

	
}
