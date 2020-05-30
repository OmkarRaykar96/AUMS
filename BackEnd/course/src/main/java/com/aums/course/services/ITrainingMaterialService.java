package com.aums.course.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.aums.course.models.TrainingMaterial;

public interface ITrainingMaterialService {

	public void addFiles(MultipartFile[] filesArr, int courseId, int trainerId);
	
	public void deleteFile(int materialId);
	
	public List<TrainingMaterial> getFilesByTrainingId(int courseId, int trainerId);
	
}
