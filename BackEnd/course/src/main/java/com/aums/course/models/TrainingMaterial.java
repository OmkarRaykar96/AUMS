package com.aums.course.models;


import java.sql.Blob;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingMaterial {
	
	private int materialId;
	private Blob file;
	private String fileName;
	private String fileType;
	
}
