package jpa.service;

import java.util.List;

import jpa.dao.StudentDAO;
import jpa.entity.models.Course;
import jpa.entity.models.Student;

public class StudentService implements StudentDAO{

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudentByEmail(String sEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateStudent(String sEmail, String sPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void registerStudentToCourse(String sEmail, int cId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Course> getStudentCourses(String sEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
