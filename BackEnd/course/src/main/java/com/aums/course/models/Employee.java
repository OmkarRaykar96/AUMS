package com.aums.course.models;

import java.sql.Blob; 

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Employee {

	private int empId;
	private String empEmail;
	private String empName;
	private String empDesignation;
	private String empLocation;
	private Blob empImage;
	private String role;
	
}
