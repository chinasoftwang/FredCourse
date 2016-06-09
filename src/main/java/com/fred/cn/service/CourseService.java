package com.fred.cn.service;

import java.util.List;

import com.fred.cn.dto.Exposer;
import com.fred.cn.entity.Course;
import com.fred.cn.exception.CourseNotExistsException;
import com.fred.cn.exception.RepeatAddCourseException;

public interface CourseService {
	// 课程列表
	public List<Course> getCourseList();

	// 单个课程
	public Course getCourseById(long courseId);

	// 添加课程
	public long addCourse(Course course) throws RepeatAddCourseException;

	// 删除课程
	public void deleteCourse(long courseId) throws Exception;

	// 获取课程地址
	public Exposer exportCourseUrl(long courseId);

	// 查看课程
	public void viewCourse(long courseId, String md5)
			throws CourseNotExistsException;

}
