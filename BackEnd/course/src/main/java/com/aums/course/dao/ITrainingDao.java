package com.aums.course.dao;

import java.util.List;

import com.aums.course.models.Employee;

public interface ITrainingDao {

	public void addOrUpdateTrainer(int employeeId);
	
	public void assignTrainers(int courseId,int employeeId);
	
	public void unassignTrainers(int courseId,int trainerId);
	
	public int validateTrainer(int trainerId);
	
	public void updateTrainerStatus(int trainerId);
	
	public List<Employee> getTrainersByCourseId(int courseId);

	public List<Employee> getAllEmployees();
	
}
