package com.aums.course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aums.course.models.TrainingMaterial;
import com.aums.course.services.TrainingMaterialService;


@RestController
@RequestMapping("api/trainingMaterial")
public class TrainingMaterialController {

	@Autowired
	TrainingMaterialService trainingMaterialService;
	
	@PostMapping("/add")
	public void addFiles(@RequestParam("files[]") MultipartFile[] filesArr,@RequestParam("courseId") int courseId, @RequestParam("trainerId") int trainerId) throws Exception {
		trainingMaterialService.addFiles(filesArr, courseId, trainerId);
	}
	
	@PostMapping("/delete")
	public void deleteFilesByFileId(@RequestBody int fileId)  {
		System.out.println("Files to delete"+fileId);
		trainingMaterialService.deleteFile(fileId);
	}
		
	@GetMapping("/files/{courseId}/{trainerId}")
	public List<TrainingMaterial> getFilesByTrainingId(@PathVariable("courseId") int courseId, @PathVariable("trainerId") int trainerId) {
		return trainingMaterialService.getFilesByTrainingId(courseId, trainerId);
	}

}

