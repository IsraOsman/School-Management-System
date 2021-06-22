package jpa.entity.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
	
	@Id
	@Column(name="id", nullable = false, length = 50)
	private int cId; 
	@Column(name="name", nullable = false, length = 50)
	private String cName;
	@Column(name="instructor", nullable = false, length = 50)
	private String cInstructorName;
	
	
	public Course() {
	}
	
	public Course(int cId, String cName, String cInstructorName) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cInstructorName = cInstructorName;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcInstructorName() {
		return cInstructorName;
	}
	public void setcInstructorName(String cInstructorName) {
		this.cInstructorName = cInstructorName;
	} 
	
	
	
}
