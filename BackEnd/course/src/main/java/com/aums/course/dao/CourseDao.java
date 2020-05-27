package com.aums.course.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aums.course.queries.Queries;
import com.aums.course.models.Course;
import com.aums.course.rowmapper.CourseRowMapper;

@Repository
public class CourseDao {

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	public List<Course> getAllCourses() {
		return jdbcTemplate.query(Queries.GET_ALL_COURSES,CourseRowMapper.CourseRowMapperLambda);
	}
	
	public Course getCourseById(int id) {
		return jdbcTemplate.queryForObject(Queries.GET_COURSE_BY_ID,CourseRowMapper.CourseRowMapperLambda,id);
	}
	
	public List<Course> getCourseForAdmin(int id) {
		return jdbcTemplate.query(Queries.GET_COURSES_FOR_ADMIN,CourseRowMapper.CourseRowMapperLambda, id);
	}
	
	public List<Course> getCourseForTrainer(int id) {
		return jdbcTemplate.query(Queries.GET_COURSES_FOR_TRAINER,CourseRowMapper.CourseRowMapperLambda, id);
	}
	
	public void updateCourse(Course course) {
		jdbcTemplate.update(Queries.UPDATE_COURSE, course.getCourseDescription(), course.getCourseLocation(), course.getCourseName(), course.getCoursePrerequisites(), course.getCourseSkills(), course.getCourseId());
	}
	
	public void deleteCourse(int id) {
		jdbcTemplate.update(Queries.DELETE_COURSE, id);
	}
	
	public void addCourse(Course course) {
		jdbcTemplate.update(Queries.ADD_COURSE, course.getCourseDescription(), course.getCourseLocation(), course.getCourseName(), course.getCoursePrerequisites(), course.getCourseSkills(), course.getCourseAdminId());
	}
}
