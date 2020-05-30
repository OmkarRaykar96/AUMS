package com.aums.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aums.course.dao.TrainingDao;
import com.aums.course.models.Employee;

@Service
public class TrainingService implements ITrainingService {

	@Autowired
	TrainingDao trainingDao;
	
	TrainingService () {
		
	}
	
	public void assignTrainers(int courseId, int employeeId) {
		trainingDao.addOrUpdateTrainer(employeeId);
		trainingDao.assignTrainers(courseId, employeeId);
	}
	
	public void unassignTrainers(int courseId, int trainerId) {
		
		trainingDao.unassignTrainers(courseId, trainerId);
		if(trainingDao.validateTrainer(trainerId) == 0) {
			trainingDao.updateTrainerStatus(trainerId);
		}
	}
	
	public List<Employee> getTrainersByCourseId(int courseId) {
		return trainingDao.getTrainersByCourseId(courseId);
	}
	
}
