package com.aums.course.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import com.aums.course.dao.TrainingMaterialDao;
import com.aums.course.models.TrainingMaterial;

@SpringBootTest()
public class TrainingMaterialServiceTest {

	@InjectMocks
	private TrainingMaterialService trainingMaterialService;

	@Mock
	private TrainingMaterialDao trainingMaterialDao;

	
	TrainingMaterial trainingMaterial = new TrainingMaterial();
	List<TrainingMaterial> list = new ArrayList<>();
	
	
	
	@BeforeEach
	public void init() {
		
		trainingMaterial.setFileId(1);
		trainingMaterial.setFileName("abc");
		trainingMaterial.setFileType("application/pdf");
		trainingMaterial.setMaterialId(1);
		trainingMaterial.setTrainerId(1);
//		trainingMaterial.setFile(CDRIVES);
		list.add(trainingMaterial);
		list.add(trainingMaterial);
	}
	
//	@Test
//	public void addFiles () throws IOException, SQLException {
//		Mockito.when(trainingMaterialDao.addFiles([new MultipartFile(), new MultipartFile()], 1, 2)).thenReturn(course1);
//		assertEquals(course1,trainingMaterialService.getCourseById(1));
//		
//	}

	@Test
	public void deleteFile() {
		Mockito.when(trainingMaterialDao.deleteFile(33)).thenReturn("File deleted");
		assertEquals("File deleted",trainingMaterialService.deleteFile(33));
	}

	@Test
	public void getFilesByTrainingId() {
		Mockito.when(trainingMaterialDao.getFilesByTrainingId(1)).thenReturn(list);
		assertEquals(list,trainingMaterialService.getFilesByTrainingId(1,2));
		
		Mockito.when(trainingMaterialDao.getTrainingId(1,2)).thenReturn(1);
		assertEquals(1,trainingMaterialService.getFilesByTrainingId(1,2));
	}

	
}
