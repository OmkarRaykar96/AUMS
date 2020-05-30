package com.aums.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.aums.course.dao.EmailDao;
import com.aums.course.models.Course;
import com.aums.course.models.Employee;

@Service
public class EmailService {
	
	@Autowired
	EmailDao emailDao;
	
	public void sendMailToParticipants(@RequestParam Employee employee,@RequestParam Course course,@RequestParam("attachments[]") MultipartFile[] files) {
		sendMailToParticipants(employee,course,files);
	}
	
}
