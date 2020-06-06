package com.aums.course.models;

import java.util.Date;  

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TrainingMaterial {
	
	private int fileId;
	private int materialId;
	private byte[] file;
	private String fileName;
	private String fileType;
	
	private int trainerId;
	private String trainerName;
	
	private Date uploadedOn;
	private Date deletedOn;
	
}
