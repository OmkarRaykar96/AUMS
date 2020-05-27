package com.aums.course.rowmapper;

import org.springframework.jdbc.core.RowMapper;

import com.aums.course.constants.AttributeMapper;
import com.aums.course.models.TrainingMaterial;

public class TrainingMaterialRowMapper {

	private TrainingMaterialRowMapper() {
		
	}
	
	public static final RowMapper<TrainingMaterial> TrainingMaterialRowMapperLambda = (rs, rowNum) -> {

		TrainingMaterial model = new TrainingMaterial();

		model.setMaterialId(rs.getInt(AttributeMapper.MATERIAL_ID));
		model.setFile(rs.getBlob(AttributeMapper.MATERIAL_FILE));
		model.setFileName(rs.getString(AttributeMapper.MATERIAL_FILE_NAME));
		model.setFileType(rs.getString(AttributeMapper.MATERIAL_FILE_TYPE));

		return model;
	};
	
}
