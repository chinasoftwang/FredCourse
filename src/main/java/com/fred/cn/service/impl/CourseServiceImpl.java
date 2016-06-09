package com.fred.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fred.cn.dao.CourseDao;
import com.fred.cn.dto.Exposer;
import com.fred.cn.entity.Course;
import com.fred.cn.exception.CourseNotExistsException;
import com.fred.cn.exception.RepeatAddCourseException;
import com.fred.cn.service.CourseService;

@Service("courseService")
public class CourseServiceImpl implements CourseService {
	// private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CourseDao courseDao;

	// 用户混淆MD5
	// private final String slat = "%372#&@KD]KAKI23829dkads[";
	@Override
	public List<Course> getCourseList() {
		List<Course> list = courseDao.getCourseList();
		return list;
	}

	@Override
	public Course getCourseById(long courseId) {
		Course course = courseDao.getCourseById(courseId);
		System.out.println("course: " + course);
		return course;
	}

	@Override
	public long addCourse(Course course) throws RepeatAddCourseException {

		return courseDao.addCourse(course);
	}

	@Override
	public void deleteCourse(long courseId) throws Exception {
		courseDao.deleteCourse(courseId);

	}

	@Override
	public Exposer exportCourseUrl(long courseId) {

		return null;
	}

	@Override
	public void viewCourse(long courseId, String md5)
			throws CourseNotExistsException {
		System.out.println("todo todo...s");

	}

}
