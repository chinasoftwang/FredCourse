package com.fred.cn.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fred.cn.entity.Course;

public class CourseServiceTest {
	static ApplicationContext context;
	private static CourseService courseService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		courseService = context.getBean(CourseService.class);
	}

	@Test
	public void testGetCourseList() {
		List<Course> list = courseService.getCourseList();
		System.out.println(list.size());
		for (Course c : list) {
			System.out.println(c);
		}
	}

	@Test
	public void testGetCourse() {
		Course course = courseService.getCourseById(4);
		System.out.println("course: " + course);
	}

	@Test
	public void testAddCourse() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteCourse() {
		fail("Not yet implemented");
	}

}
