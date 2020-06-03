	package com.aums.course.services;

import java.util.List; 

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.aums.course.dao.TrainingDao;
import com.aums.course.models.Email;
import com.aums.course.models.Employee;

@Service
public class TrainingService implements ITrainingService {

	@Autowired
	private TrainingDao trainingDao;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	TrainingService () {
		
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		return trainingDao.getAllEmployees();
	}
	
	@Override
	public String assignTrainers(int courseId, int employeeId) {
		trainingDao.addOrUpdateTrainer(employeeId);
		trainingDao.assignTrainers(courseId, employeeId);
		return "Trainer Assigned Successfully!!";
	}
	
	@Override
	public String unassignTrainers(int courseId, int trainerId) {
		if(trainingDao.validateTrainer(trainerId) == 0) {
			trainingDao.updateTrainerStatus(trainerId);
		}
		return trainingDao.unassignTrainers(courseId, trainerId);
	}
	
	@Override
	public List<Employee> getTrainersByCourseId(int courseId) {
		return trainingDao.getTrainersByCourseId(courseId);
	}

	@Override
	public String sendMail(Email obj) throws MessagingException {
			MimeMessage msg = javaMailSender.createMimeMessage();
			
			MimeMessageHelper helper = new MimeMessageHelper(msg, true);

			
			String message = "Dear AUers," + "\n\n" +
				      "Please make a note of the following:" + "\n" +
				      "Course Name - " + obj.getCourseName() + "\n" +
				      "Details - " + obj.getCourseDescription() + "\n" +
				      "Location - " + obj.getCourseLocation() + "\n" +
				      "You are required to prepare for the following topics prior " +
				      "to the commencement of this course: " + obj.getCoursePrerequisites() + "\n" +
				      "Expected Skills you\'ll gain post completion of the course : " + obj.getCourseSkills() + "\n" +
				      "This mail was generated by: " + obj.getTrainerName() + "\n" +
				      "\n\nFor more details please visit <a href=\"http://accolite.com/career.html\"> Accolite\'s Official Website </a>" + "\n" +
				      "\n\nRegards,\n <b> AU Team </b>";
			
			try {
				helper.setTo(obj.getMailRecepient());
				helper.setSubject(obj.getMailSubject());
				helper.setText(message);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			
			javaMailSender.send(msg);
			return trainingDao.sendMail();
	}
	
}
