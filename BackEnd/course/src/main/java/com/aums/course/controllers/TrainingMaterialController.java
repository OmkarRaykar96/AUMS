package com.aums.course.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aums.course.models.TrainingMaterial;

@RestController
@RequestMapping("api/trainingMaterial")
public class TrainingMaterialController {

	public void addFilesByTrainingId(int TrainingId){
		
	}
	
	public void deleteFilesByTrainingId(){
		
	}
	
	public List<TrainingMaterial> getFilesByCourseId() {
		return new ArrayList<TrainingMaterial>();
	}
		
}
