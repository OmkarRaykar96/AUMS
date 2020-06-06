package com.aums.course.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Course {
	
 private int courseId;
 private String courseDescription;
 private String courseLocation;
 private String courseName;
 private String coursePrerequisites;
 private String courseSkills;
 private int courseAdminId;
 
}
