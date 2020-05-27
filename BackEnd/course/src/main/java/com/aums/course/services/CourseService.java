package com.aums.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aums.course.dao.CourseDao;
import com.aums.course.models.Course;

@Service
public class CourseService {

	@Autowired
	CourseDao courseDao;
	
	public List<Course> getAllCourses() {
		return courseDao.getAllCourses();
	}
	
	public Course getCourseById(int id) {
		return courseDao.getCourseById(id);
	}
	
	public List<Course> getCourseForAdmin(int id) {
		return courseDao.getCourseForAdmin(id);
	}
	
	public List<Course> getCourseForTrainer(int id) {
		return courseDao.getCourseForTrainer(id);
	}
	
	public void updateCourse(Course course) {	
		courseDao.updateCourse(course);
	}
	
	public void deleteCourse(int id) {
		courseDao.deleteCourse(id);
	}
	
	public void addCourse(Course course) {
		courseDao.addCourse(course);
	}
	
}
