package com.aums.course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aums.course.models.Employee;
import com.aums.course.services.TrainingService;

@RestController
@RequestMapping("api/training")
public class TrainingController {

	@Autowired
	TrainingService trainingService;
	
	private TrainingController() {
		
	}
	
	@PostMapping("/api/assignTrainers/{courseId}/{employeeId}")
	public void assignTrainers(@PathVariable("courseId") int courseId,@PathVariable("employeeId") int employeeId) {
		trainingService.assignTrainers(courseId,employeeId);
	}
	
	@PostMapping("/api/unassignTrainers/{courseId}/{trainerId}")
	public void unassignTrainers(@PathVariable("courseId") int courseId,@PathVariable("trainerId") int trainerId) {
		trainingService.unassignTrainers(courseId, trainerId);
	}
	
	@GetMapping("api/getTrainersByCourseId/{courseId}") 
	public List<Employee> getTrainersByCourseId(int courseId) {
		return trainingService.getTrainersByCourseId(courseId);
	}
	
}


