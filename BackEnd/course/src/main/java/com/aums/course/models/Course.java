package com.aums.course.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	
 private int courseId;
 private String courseDescription;
 private String courseLocation;
 private String courseName;
 private String coursePrerequisites;
 private String courseSkills;
 private int courseAdminId;
 
}
