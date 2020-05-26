package com.aums.course.queries;

public class Queries {
	
	// Login
	public static final String VALIDATE_LOGIN = "SELECT * FROM employee where emp_email_id=?";
	public static final String CHECK_ADMIN = "SELECT COUNT(admin_id) FROM system_admin where admin_id=?";
	public static final String CHECK_TRAINER = "SELECT COUNT(trainer_id) FROM trainer where trainer_id=? and active_flag='Y'";
	
	// Course
	public static final String GET_ALL_COURSES = "SELECT * from course where course_active_flag='Y'";
	public static final String GET_COURSE_BY_ID = "SELECT * from course where course_id=?";
	public static final String UPDATE_COURSE = "UPDATE course set course_description=?, course_location=?, course_name=?, course_prerequisites=?, course_skills=?, course_active_flag='Y' where course_id=?";
	public static final String DELETE_COURSE = "UPDATE course set course_active_flag='N' where course_id=?";
	public static final String ADD_COURSE = "INSERT INTO course (course_description,course_location,course_name,course_prerequisites,course_skills,course_admin_id,course_active_flag)VALUES(?,?,?,?,?,?,'Y')";
	
	// Trainer
	public static final String ASSIGN_TRAINER = "";
	public static final String UNASSIGN_TRAINER = "";
	public static final String GET_TRAINERS_BY_COURSE = "";
	public static final String GET_COURSES_BY_TRAINER = "";
	
	// Training Material
	public static final String ADD_FILES_BY_TRAINING = "";
	public static final String DELETE_FILES_BY_TRAINING = "";
	public static final String GET_FILES_BY_COURSE = "";
	
	
	
}