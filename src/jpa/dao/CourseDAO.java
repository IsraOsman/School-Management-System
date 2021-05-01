package jpa.dao;

import java.util.List;

import jpa.entity.models.Course;

public interface CourseDAO {
	public List<Course> getAllCourses();
}
