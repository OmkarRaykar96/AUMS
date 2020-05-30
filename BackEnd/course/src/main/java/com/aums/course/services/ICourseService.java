package com.aums.course.services;

import java.util.List;

import com.aums.course.models.Course;

public interface ICourseService {

	public List<Course> getAllCourses();
	
	public Course getCourseById(int id);
	
	public List<Course> getCourseForAdmin(int id);
	
	public List<Course> getCourseForTrainer(int id);
	
	public void updateCourse(Course course);
	
	public void deleteCourse(int id);
	
	public void addCourse(Course course);
}
