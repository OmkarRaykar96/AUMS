package com.aums.course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aums.course.models.Course;
import com.aums.course.services.CourseService;

@RestController
@RequestMapping("api/course")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@GetMapping("/getAllCourses")
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	};
	
	@GetMapping("/getCourse/{id}")
	public Course getCourseById(@PathVariable int id) {
		return courseService.getCourseById(id);
	};
	
	@PostMapping("/updateCourse")
	public void updateCourse(@RequestBody Course course){
		courseService.updateCourse(course);
	};
	
	@PostMapping("/deleteCourse/{id}")
	public void deleteCourse(@PathVariable int id){
		courseService.deleteCourse(id);
	};
	
	@PostMapping("/addCourse")
	public void addCourse(@RequestBody Course course){
		courseService.addCourse(course);
	};
	
}
