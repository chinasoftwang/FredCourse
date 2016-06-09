package com.fred.cn.dto;

public class Exposer {

	private boolean exposed;

	// 对课程的URL进行加密
	private String md5;

	private long courseId;
	// 当前时间
	private long now;

	private long start;

	private long end;

	public Exposer(boolean exposed, String md5, long courseId) {
		this.exposed = exposed;
		this.md5 = md5;
		this.courseId = courseId;
	}

	public Exposer(boolean exposed, long now, long start, long end) {
		this.exposed = exposed;
		this.now = now;
		this.start = start;
		this.end = end;
	}

	public Exposer(boolean exposed, long courseId) {
		this.exposed = exposed;
		this.courseId = courseId;
	}

	public boolean isExposed() {
		return exposed;
	}

	public void setExposed(boolean exposed) {
		this.exposed = exposed;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public long getNow() {
		return now;
	}

	public void setNow(long now) {
		this.now = now;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}

}
