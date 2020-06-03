package com.aums.course.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.aums.course.models.Course;
import com.aums.course.services.CourseService;
import com.aums.course.utils.Utils;

@SpringBootTest()
@AutoConfigureMockMvc
public class CourseControllerTest {

	Course course1 = new Course();
	Course course2 = new Course();
	List<Course> courses = new ArrayList<>();
	
	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private CourseController courseController;
	
	@MockBean
	private CourseService courseService;

	@BeforeEach
	public void init() {
		course1.setCourseId(1);
		course1.setCourseAdminId(1);
		course1.setCourseDescription("Front End Library");
		course1.setCourseLocation("Bangalore");
		course1.setCourseName("React JS");
		course1.setCoursePrerequisites("JavaScript");
		course1.setCourseSkills("FrontEnd");
		
		course2.setCourseId(2);
		course2.setCourseAdminId(1);
		course2.setCourseDescription("Back End Framework");
		course2.setCourseLocation("Mumbai");
		course2.setCourseName("Spring MVC");
		course2.setCoursePrerequisites("Java");
		course2.setCourseSkills("APIs");
		
		courses.add(course1);
		courses.add(course2);
	}
	
	
	@Test
	public void getCourseById() throws Exception {

		
		when(courseService.getCourseById(1)).thenReturn(course1);
		
		mockMvc.perform(get("/api/course/1")).andDo(print())
	    .andExpect(status().isOk());
	}
	
	@Test
	public void getAllCourse() throws Exception {
		
		when(courseService.getAllCourses()).thenReturn(courses);
		
		mockMvc.perform(get("/api/course/all")).andDo(print())
	    .andExpect(status().isOk());
	}
	
	@Test
	public void addCourse() throws Exception {

		
//		Course testcourse = course;
		
		
		when(courseService.addCourse(course1)).thenReturn("Course Added Successfully");
		
//		assertEquals("Course Added Successfully",courseService.addCourse(course));
		mockMvc.perform(post("/api/course/add")
			    .content(Utils.asJsonString(course1))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
//				.andExpect(ResultMatcher.contentTypeCompatibleWith(String.class))
				.andReturn();
	}
	
	@Test
	public void updateCourse() {
		
		
		when(courseService.updateCourse(course1)).thenReturn("Course Updated Successfully");
		assertEquals("Course Updated Successfully",courseController.updateCourse(course1));
//		mockMvc.perform(post("/api/course/save")
//				 	.content(Utils.asJsonString(course))
//					.contentType(MediaType.APPLICATION_JSON)
//					.accept(MediaType.APPLICATION_JSON))
//					.andExpect(status().isOk())
//					.andReturn();
	}
	
	@Test
	public void deleteCourse() {
		
		when(courseService.deleteCourse(course1.getCourseId())).thenReturn("Course Deleted Successfully");
		assertEquals("Course Deleted Successfully",courseController.deleteCourse(course1));
//		mockMvc.perform(delete("/api/course/delete/2")
//				.contentType(MediaType.APPLICATION_JSON)
//				.characterEncoding("utf-8"))
//				.andExpect(status().isOk())
//				.andReturn();
	}
	
	@Test
	public void getCourseByCreatorId() throws Exception {
		when(courseService.getCourseForAdmin(1)).thenReturn(courses);
		mockMvc.perform(get("/api/course/admin/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void getCourseByInstructorId() throws Exception {
		
		when(courseService.getCourseForTrainer(1)).thenReturn(courses);
		mockMvc.perform(get("/api/course/trainer/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}


}
