package com.aums.course.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Trial {

	@GetMapping("/trial")
	public String trialController() {
		return "Chal gaya";
	}
	
}