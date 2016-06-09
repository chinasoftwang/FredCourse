package com.fred.cn.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fred.cn.entity.Course;
import com.fred.cn.service.CourseService;

public class CourseList {

	//private ApplicationContext context;

	//private CourseService courseService;

//	public CourseList() {
//		context = new ClassPathXmlApplicationContext(
//				"classpath:applicationContext.xml");
//		courseService = context.getBean(CourseService.class);
//	}

	public List<Course> getCourseList() {
		List<Course> list = new ArrayList<Course>();
		// list = courseService.getCourseList();
		String[] course = { "JAVA", "C++", "PLSQL", "JavaScript" };

		try {
			for (int i = 0; i < course.length; i++) {
				Course c = new Course();
				c.setCourseName(course[i]);
				c.setTeacher("wanganlei");
				c.setCourseType("language");
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				sdf.format(new Date());
				Date d;
				d = sdf.parse("2016-05-01 23:41:34");
				c.setStartDate(d);
				c.setEndDate(d);
				list.add(c);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	public static void main(String[] args) {
		System.out.println("start");
		List<Course> list = new CourseList().getCourseList();
		for (Course c: list) {
			System.out.println(c);
		}
	}

}
