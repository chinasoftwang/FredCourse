package com.fred.cn.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fred.cn.entity.Course;

public class CourseDaoTest {
	static ApplicationContext context;
	private static CourseDao courseDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		courseDao = context.getBean(CourseDao.class);
	}

	@Test
	public void testAddCourse() {
		Course course = new Course();
		course.setCourseName("JAVA");
		course.setCourseType("computer language");
		course.setCourseDescription("java");
		course.setCreateBy("wanganlei");
		course.setCreateDate(new Date());
		courseDao.addCourse(course);
		long courseId = course.getCourseId();
		System.out.println(courseId);
	}

	@Test
	public void testDeleteCourse() {
		courseDao.deleteCourse(2);
	}

	@Test
	public void testUpdateCourse() {
		Course course = new Course();
		course.setCourseId(2);
		course.setCourseName("Java");
		course.setCourseType("computer language");
		course.setCourseDescription("My Junit Test!!!");
		course.setCreateBy("wanganlei");
		course.setCreateDate(new Date());
		courseDao.updateCourse(course);

	}

	@Test
	public void testGetCourseById() {
		long courseId = 2;
		Course course = courseDao.getCourseById(courseId);
		System.out.println(course);
	}

	@Test
	public void testGetCourseList() {
		List<Course> courseList = courseDao.getCourseList();
		System.out.println(courseList.size());
		assertTrue(courseList.size() > 0);
	}

}
