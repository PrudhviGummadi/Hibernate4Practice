package com.hibernate.inheritance.tableperclass;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "person")
@DiscriminatorColumn(name = "discriminator_value", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "E")
public class Employee extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3363149966776776010L;

	private String deptName;

	private Date joiningDate;

	@Column(name = "dept_name")
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name = "joining_date")
	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return "Employee [deptName=" + deptName + ", joiningDate=" + joiningDate + ", id()=" + getId()
				+ ", firstName()=" + getFirstName() + ", lastName()=" + getLastName() + "]";
	}

}
