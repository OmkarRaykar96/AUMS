package com.aums.course.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.aums.course.models.Course;
import com.aums.course.models.Employee;

@Repository
public class EmailDao {
	
	public void sendMailToParticipants(@RequestParam Employee employee,@RequestParam Course course,@RequestParam("attachments[]") MultipartFile[] files) {
		
	}
	
}
