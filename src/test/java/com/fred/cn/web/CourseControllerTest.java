package com.fred.cn.web;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CourseControllerTest {

	static ApplicationContext context;
	private static CourseController courseController;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		courseController = context.getBean(CourseController.class);
	}

	@Test
	public void testGetCourseList() {
		// Object object = courseController.getCourseList();
		// System.out.println(object);
	}

}
