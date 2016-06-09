package com.fred.cn.dao;

import java.util.List;

import com.fred.cn.entity.Course;

public interface CourseDao {

	// add course info
	long addCourse(Course course);

	// delete course by courseId
	void deleteCourse(long courseId);

	// update course
	void updateCourse(Course course);

	// get course info by courseId
	Course getCourseById(long courseId);

	// get all course info
	List<Course> getCourseList();
}
