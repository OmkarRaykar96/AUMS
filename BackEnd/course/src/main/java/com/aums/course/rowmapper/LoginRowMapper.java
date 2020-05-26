package com.aums.course.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import com.aums.course.models.Employee;

public class LoginRowMapper {

	private LoginRowMapper() {
		
	}
	
	public static final RowMapper<Employee> LoginRowMapperLambda = (rs, rowNum) -> {

		Employee model = new Employee();

		model.setEmpId(rs.getInt("emp_id"));
		model.setEmpEmail(rs.getString("emp_email_id"));
		model.setEmpName(rs.getString("emp_name"));
		model.setEmpDesignation(rs.getString("emp_designation"));
		model.setEmpLocation(rs.getString("emp_location"));
		model.setEmpImage(rs.getBlob("emp_img"));

		return model;
		
	};
}
