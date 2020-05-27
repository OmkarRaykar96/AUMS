package com.aums.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aums.course.dao.TrainingMaterialDao;
import com.aums.course.models.TrainingMaterial;

@Service
public class TrainingMaterialService {

	@Autowired
	TrainingMaterialDao trainingMaterialDao;
	
	public void addFiles(MultipartFile[] filesArr, int courseId, int trainerId) {
		trainingMaterialDao.addFiles(filesArr, trainingMaterialDao.getTrainingId(courseId, trainerId));
	}
	
	public void deleteFile(int materialId) {
		trainingMaterialDao.deleteFile(materialId);
	}
	
	public List<TrainingMaterial> getFilesByTrainingId(int courseId, int trainerId) {
		return trainingMaterialDao.getFilesByTrainingId(trainingMaterialDao.getTrainingId(courseId, trainerId));
	}
}
