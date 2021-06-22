package jpa.entity.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
	@Id
	@Column(name="email", nullable = false, length = 50)
	private String sEmail;
	@Column(name="name", nullable = false, length = 50)
	private String sName;
	@Column(name="password", nullable = false, length = 50)
	private String sPass; 
	
	@OneToMany(targetEntity = Course.class, cascade = CascadeType.ALL)
	private List sCourses = new ArrayList<Course>();
	
	
	public Student() {}
	
	
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

	
	public void setCourse(Course course) {
		this.sCourses.add(course);
	}
	
}
