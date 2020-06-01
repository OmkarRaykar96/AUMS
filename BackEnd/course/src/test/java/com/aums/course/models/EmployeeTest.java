package com.aums.course.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EmployeeTest {

	@Test
	public void employeeModelTest() {
		Employee emp = new Employee();
	
		emp.setEmpId(1);
		emp.setEmpName("Omkar");
		emp.setRole("Admin");
		emp.setEmpDesignation("SDE");
		emp.setEmpEmail("omkar.ravindraraykar@accoliteindia.com");
		emp.setEmpImage(null);
		emp.setEmpLocation("Mumbai");
		
		assertEquals(1,emp.getEmpId());
		assertEquals("Omkar",emp.getEmpName());
		assertEquals("Admin",emp.getRole());
		assertEquals("SDE",emp.getEmpDesignation());
		assertEquals("omkar.ravindraraykar@accoliteindia.com",emp.getEmpEmail());
		assertEquals(null,emp.getEmpImage());
		assertEquals("Mumbai",emp.getEmpLocation());
		
	}
	
	
	
}
