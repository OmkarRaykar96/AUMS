package com.aums.course.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.aums.course.models.TrainingMaterial;

public interface ITrainingMaterialDao {
	
	public void addFiles(MultipartFile[] filesArr, int materialId);
	
	public int getTrainingId(int courseId,int trainerId);
	
	public void deleteFile(int materialId);
	
	public List<TrainingMaterial> getFilesByTrainingId(int materialId);
	
}
