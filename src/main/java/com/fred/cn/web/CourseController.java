package com.fred.cn.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fred.cn.data.CourseList;
import com.fred.cn.dto.Exposer;
import com.fred.cn.entity.Course;
import com.fred.cn.exception.CourseNotExistsException;
import com.fred.cn.service.CourseService;
import com.fred.cn.util.ResultObj;

@Controller
@RequestMapping("/course")
public class CourseController {
	// private Logger logger = Logger.getLogger(CourseController.class);

	private ApplicationContext context;

	@Resource
	private CourseService courseService;


	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getCourseList(Model model) {
		System.out.println("courseService: " + courseService);
		CourseList list = new CourseList();
		List<Course> courseList = list.getCourseList();
		System.out.println("courseService.getCourseList(): "
				+ courseService.getCourseList());
		model.addAttribute("courseList", courseList);

		return "course/courseList";
	}

	@RequestMapping(value = "/josnList", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody
	Object courseList() {
		ResultObj obj = new ResultObj();
		Map map = new HashMap();
		List<Course> courseList = new ArrayList<Course>();
		courseList = courseService.getCourseList();
		map.put("courseList", courseList);
		obj.setData(map);
		return obj;
	}

	@RequestMapping(value = "/{courseId}/detail", method = RequestMethod.GET)
	public String getCourseDetail(@PathVariable("courseId") Long courseId,
			Model model) {
		try {
			System.out.println("courseId=========== " + courseId);
			if (courseId == null) {
				return "redirect:/course/list";
			}
			Course course = courseService.getCourseById(courseId);
			if (course == null) {
				return "forward:/course/list";
			}
			model.addAttribute("course", course);
		} catch (CourseNotExistsException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "course/courseDetail";
	}

	@RequestMapping(value = "/{courseId}/exposer", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public Object exposer(@PathVariable("courseId") Long courseId) {
		ResultObj obj = new ResultObj();
		obj.setCode("200");
		obj.setMessage("SUCCESS");
		Map map = new HashMap();
		try {
			Exposer exposer = courseService.exportCourseUrl(courseId);
			map.put("url", exposer);
			obj.setData(map);
		} catch (Exception e) {
			// logger.error(e.getMessage(), e);
			obj.setCode("201");
			obj.setMessage("ERROR");
		}

		return obj;
	}

	@RequestMapping(value = "/{courseId}/{md5}/view", method = RequestMethod.POST)
	public String viewCourse(@PathVariable("courseId") Long courseId,
			@PathVariable("md5") String md5,
			@CookieValue(value = "phone", required = false) Long phone) {
		if (phone == null) {
			return null;
		}
		return "course/courseDetail";
	}

	@RequestMapping(value = "/time/now", method = RequestMethod.GET)
	@ResponseBody
	public Object time() {
		ResultObj obj = new ResultObj();
		Date date = new Date();
		obj.setData(date.getTime());
		return obj;

	}

}
