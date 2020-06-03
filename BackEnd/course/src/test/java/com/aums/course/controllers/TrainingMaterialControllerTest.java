package com.aums.course.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.aums.course.models.TrainingMaterial;
import com.aums.course.services.TrainingMaterialService;

@SpringBootTest()
public class TrainingMaterialControllerTest {

	@InjectMocks
	private TrainingMaterialController trainingMaterialController;

	@Mock
	private TrainingMaterialService trainingMaterialService;

	
	TrainingMaterial trainingMaterial = new TrainingMaterial();
	List<TrainingMaterial> list = new ArrayList<>();
	
	@BeforeEach
	public void init() {
		trainingMaterial.setFileId(1);
		trainingMaterial.setFileName("abc");
		trainingMaterial.setFileType("application/pdf");
		trainingMaterial.setMaterialId(1);
		trainingMaterial.setTrainerId(1);
		
		list.add(trainingMaterial);
		list.add(trainingMaterial);
	}
	
	@Test
	public void deleteFile() {
		Mockito.when(trainingMaterialService.deleteFile(33)).thenReturn("File deleted");
		assertEquals("File deleted",trainingMaterialController.deleteFile(33));
	}
	
}
