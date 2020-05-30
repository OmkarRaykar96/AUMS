package com.aums.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aums.course.models.Course;
import com.aums.course.models.Employee;
import com.aums.course.services.EmailService;

@RestController
public class EmailController {

	@Autowired
	EmailService emailService;
	
	@PostMapping
	public void sendMailToParticipants(@RequestParam Employee employee,@RequestParam Course course,@RequestParam("attachments[]") MultipartFile[] files) {
		emailService.sendMailToParticipants(employee, course, files);
	}
	
}
