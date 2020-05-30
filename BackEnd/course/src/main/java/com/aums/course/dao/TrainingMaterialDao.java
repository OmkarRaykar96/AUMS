package com.aums.course.dao;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.aums.course.models.TrainingMaterial;
import com.aums.course.queries.Queries;
import com.aums.course.rowmapper.TrainingMaterialRowMapper;
@Repository
public class TrainingMaterialDao implements ITrainingMaterialDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void addFiles(MultipartFile[] filesArr, int materialId) {
		for(MultipartFile file: filesArr) {
			
			String fileName = file.getOriginalFilename();
			String extension = FilenameUtils.getExtension(fileName);
			
			byte[] binaryFile = new byte[(int) file.getSize()];
			try {
				binaryFile = file.getBytes();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			jdbcTemplate.update(Queries.ADD_FILES_BY_TRAINING, materialId, binaryFile, fileName, extension);
		}
	}
	
	public int getTrainingId(int courseId,int trainerId) {
		return jdbcTemplate.queryForObject(Queries.GET_TRAINING_ID ,Integer.class,courseId,trainerId);
	}

	public void deleteFile(int materialId) {
		jdbcTemplate.update(Queries.DELETE_FILES_BY_TRAINING,materialId);
	}
	
	public List<TrainingMaterial> getFilesByTrainingId(int materialId) {
		return jdbcTemplate.query(Queries.GET_FILES_BY_TRAINING, TrainingMaterialRowMapper.TrainingMaterialRowMapperLambda, materialId);
	}
}
