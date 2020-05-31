package com.aums.course.services;

import java.util.List;

import com.aums.course.models.Employee;

public interface ITrainingService {

	public void assignTrainers(int courseId, int employeeId);
	
	public void unassignTrainers(int courseId, int trainerId);
	
	public List<Employee> getTrainersByCourseId(int courseId);

	public List<Employee> getAllEmployees();
	
}
