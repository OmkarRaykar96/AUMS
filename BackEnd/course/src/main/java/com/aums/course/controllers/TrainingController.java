package com.aums.course.controllers;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aums.course.models.Email;
import com.aums.course.models.Employee;
import com.aums.course.models.Training;
import com.aums.course.services.TrainingService;

@RestController
@RequestMapping("api/training")
public class TrainingController {

	@Autowired
	TrainingService trainingService;
	
	private TrainingController() {
		
	}
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(){
		return trainingService.getAllEmployees();
	}
	
	@PostMapping("/assignTrainers")
	public void assignTrainers(@RequestBody Training training) {
		trainingService.assignTrainers(training.getCourseId(),training.getTrainerId());
	}
	
	@PostMapping("/unassignTrainers")
	public void unassignTrainers(@RequestBody Training training) {
		trainingService.unassignTrainers(training.getCourseId(),training.getTrainerId());
	}
	
	@GetMapping("/getTrainersByCourseId/{courseId}") 
	public List<Employee> getTrainersByCourseId(@PathVariable("courseId") int courseId) {
		return trainingService.getTrainersByCourseId(courseId);
	}
	
	@PostMapping("/sendMail")
	public void sendMail(@RequestBody Email obj) throws MessagingException {
		trainingService.sendMail(obj);
	}
}

