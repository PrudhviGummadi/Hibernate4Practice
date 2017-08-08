package com.hibernate.practice.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6481428107088522714L;

	private Integer id;

	private String name;

	private String course;

	private Date courseEndDate;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "std_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "course")
	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Column(name = "course_end_date")
	public Date getCourseEndDate() {
		return courseEndDate;
	}

	public void setCourseEndDate(Date courseEndDate) {
		this.courseEndDate = courseEndDate;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + ", courseEndDate=" + courseEndDate + "]";
	}

}
