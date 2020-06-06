package com.aums.course.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Training {

	private int trainingId;
	private int courseId;
	private int trainerId;
	private String feedback;
	
}
