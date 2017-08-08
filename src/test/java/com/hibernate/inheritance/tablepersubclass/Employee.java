package com.hibernate.inheritance.tablepersubclass;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
@PrimaryKeyJoinColumn(name = "id" /* employee table primary key */, referencedColumnName = "id" /*
																								 * person
																								 * table
																								 * primary
																								 * key
																								 * column
																								 */)
public class Employee extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1888657284178646863L;

	private String deptName;

	private Date joiningDate;

	public Employee(String id, String firstName, String lastName, String deptName, Date joiningDate) {
		super(id, firstName, lastName);
		this.deptName = deptName;
		this.joiningDate = joiningDate;
	}

	public Employee() {
	}

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
		return "Employee [deptName=" + deptName + ", joiningDate=" + joiningDate + ", id=" + getId() + ", firstName="
				+ getFirstName() + ", lastName=" + getLastName() + "]";
	}

}
