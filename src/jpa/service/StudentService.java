package jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jpa.dao.StudentDAO;
import jpa.entity.models.Course;
import jpa.entity.models.Student;

public class StudentService implements StudentDAO{
	
	
	//this method return all of the students on the student table 
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SMS");
		EntityManager entitymanager = emfactory.createEntityManager();
		Query s = entitymanager.createNativeQuery("Select s from student s", Student.class); 
		List<Student> result = s.getResultList(); 
		entitymanager.close();
		emfactory.close();
		return result;
		
	}	
	
	
	@Override
	public Student getStudentByEmail(String sEmail) {
	
		// TODO Auto-generated method stub
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SMS");
		EntityManager entitymanager = emfactory.createEntityManager();
		try {
		Student s = entitymanager.find(Student.class, sEmail);
		entitymanager.close(); 
		emfactory.close();
		return s;
		
		} catch (NullPointerException e) {
			System.out.print("Null values are not accepted");
			return null; 
		}
	}

	

	@Override
	public boolean validateStudent(String sEmail, String sPassword) {
		// TODO Auto-generated method stub
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SMS");
		EntityManager entitymanager = emfactory.createEntityManager();
		try {
		StudentService studentServ = new StudentService(); 
		Student student = studentServ.getStudentByEmail(sEmail);
		
		if(student.getsEmail().equals(sEmail) && student.getsPass().equals(sPassword)) {
			return true; 
		} else {
			return false;
		}
		}catch (NullPointerException e) {
			System.out.println("Email and Password can't be null");
			return false;
		}
		
		
	}

	@Override
	public void registerStudentToCourse(String sEmail, int cId) {
		// TODO Auto-generated method stub
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SMS");
		EntityManager entitymanager = emfactory.createEntityManager();
		try {
		entitymanager.getTransaction().begin();
		StudentService studentServ = new StudentService(); 
		Student student = studentServ.getStudentByEmail(sEmail);
		Course c = entitymanager.find(Course.class, cId); 
		student.setCourse(c);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
		
		} catch (NullPointerException e){
			System.out.println("Email Or Id can't be null");
		}
	}

	@Override
	public List<Course> getStudentCourses(String sEmail) {
		
		// TODO Auto-generated method stub
		try {
		StudentService stu = new StudentService(); 
		Student student = stu.getStudentByEmail(sEmail);
		List<Course> li = student.getsCourses();
		return li;
		} catch (NullPointerException e) {
			System.out.print("Email can't be null");
			return null; 
		}
	}
	
	
	

	
}
