package jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jpa.dao.CourseDAO;
import jpa.entity.models.Course;

public class CourseService implements CourseDAO{


	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SMS");
	EntityManager entitymanager = emfactory.createEntityManager();
	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		Query course = entitymanager.createQuery("select c from Course c");
		List<Course> courses = course.getResultList();
		return courses;
	}
	

}



