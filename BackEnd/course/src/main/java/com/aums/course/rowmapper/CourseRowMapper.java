package com.aums.course.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import com.aums.course.models.Course;

public class CourseRowMapper {
	
	private CourseRowMapper() {
		
	}
	
	public static final RowMapper<Course> CourseRowMapperLambda = (rs, rowNum) -> {

		Course model = new Course();

		model.setCourseId(rs.getInt("course_id"));
		model.setCourseDescription(rs.getString("course_description"));
		model.setCourseLocation(rs.getString("course_location"));
		model.setCourseName(rs.getString("course_name"));
		model.setCoursePrerequisites(rs.getString("course_prerequisites"));
		model.setCourseSkills(rs.getString("course_skills"));
		model.setCourseAdminId(rs.getInt("course_admin_id"));
		
		return model;
		
	};
}
