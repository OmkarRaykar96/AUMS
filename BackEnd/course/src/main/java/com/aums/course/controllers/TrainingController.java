package com.aums.course.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aums.course.models.Course;
import com.aums.course.models.Trainer;
import com.aums.course.models.Training;

@RestController
@RequestMapping("api/training")
public class TrainingController {

	private TrainingController() {
		
	}
	
	@PostMapping("/api/assignTrainers")
	public void assignTrainers(@RequestBody Training[] training) {
		
	}
	
//	@PostMapping("/api/updateTrainers")
//	public void updateTrainers(@RequestBody Training[] training) {
//		
//	}
	
	@PostMapping("/api/unassignTrainers")
	public void unassignTrainers(@RequestBody Training[] training) {
		
	}
	
	@GetMapping("api/getTrainersByCourseId/{courseId}") 
	public List<Trainer> getTrainersByCourseId () {
		return new ArrayList<Trainer>();
	}
	
	@GetMapping("api/getCoursesByTrainerId/{trainerId}")
	public List<Course> getCoursesByTrainerId () {
		return new ArrayList<Course>();
	}
	
}
