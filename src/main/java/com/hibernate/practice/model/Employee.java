package com.hibernate.practice.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="EMP")
public class Employee {

	private int id;
	
	private String name;
	
	private int deptNo;
	
	private String job;
	
	private int sal;
	
	private int comm;
	
	private int mgrNo;
	
	private Date hireDate;
	
	private boolean active;

	@Column(name="empno", nullable=false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="ename")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="deptno")
	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	@Column(name="job")
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Column(name="sal")
	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	@Column(name="comm")
	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	@Column(name="mgr")
	public int getMgrNo() {
		return mgrNo;
	}

	public void setMgrNo(int mgrNo) {
		this.mgrNo = mgrNo;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
