package com.aums.course.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingMaterial {
	
	private int fileId;
	private int materialId;
	private byte[] file;
	private String fileName;
	private String fileType;
	private int trainerId;
	
}
