package com.aums.course.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CourseTest {

	@Test
	public void courseModelTest() {
		Course course = new Course();
		
		course.setCourseId(1);
		course.setCourseName("JUnit and Mockito");
		course.setCourseLocation("Mumbai");
		course.setCourseAdminId(2);
		course.setCourseDescription("The unexplored part of Java");
		course.setCoursePrerequisites("prerequisites");
		course.setCourseSkills("skills");
		
		assertEquals(1,course.getCourseId());
		assertEquals("JUnit and Mockito",course.getCourseName());
		assertEquals("Mumbai",course.getCourseLocation());
		assertEquals(2,course.getCourseAdminId());
		assertEquals("The unexplored part of Java",course.getCourseDescription());
		assertEquals("prerequisites",course.getCoursePrerequisites());
		assertEquals("skills",course.getCourseSkills());}
}
