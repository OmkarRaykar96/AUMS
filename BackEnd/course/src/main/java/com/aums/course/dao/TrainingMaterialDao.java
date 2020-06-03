package com.aums.course.dao;

import java.sql.Blob; 
import java.util.List;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

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
	
	@Override
	public void addFiles(MultipartFile[] filesArr, int trainingId) throws IOException, SerialException, SQLException {
		for(MultipartFile file : filesArr) {
			byte[] bytes = file.getBytes();
		    Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
		   jdbcTemplate.update(Queries.ADD_FILES_BY_TRAINING, trainingId, blob, file.getOriginalFilename(), file.getContentType());
		}
	}
	
	@Override
	public int getTrainingId(int courseId,int trainerId) {
		return jdbcTemplate.queryForObject(Queries.GET_TRAINING_ID ,Integer.class,courseId,trainerId);
	}

	@Override
	public void deleteFile(int fileId) {
		jdbcTemplate.update(Queries.DELETE_FILES_BY_TRAINING,fileId);
	}
	
	@Override
	public List<TrainingMaterial> getFilesByTrainingId(int materialId) {
		return jdbcTemplate.query(Queries.GET_FILES_BY_TRAINING, TrainingMaterialRowMapper.TrainingMaterialRowMapperLambda, materialId);
	}
}
