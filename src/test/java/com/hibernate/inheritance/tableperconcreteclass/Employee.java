package com.hibernate.inheritance.tableperconcreteclass;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@AttributeOverrides({ @AttributeOverride(name = "firstName", column = @Column(name = "first_name")),
		@AttributeOverride(name = "lastName", column = @Column(name = "last_name")),
		@AttributeOverride(name = "id", column = @Column(name = "id")) })
// firstName== is the property in the person class and first_name== is the
// column name in the employee table
// lastName==property in the person class and last_name=is the column name in
// the employee table
@Table(name = "employee")
public class Employee extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = -185569483967528056L;

	private String deptName;

	private Date joiningDate;

	public Employee(Integer id, String firstName, String lastName, String deptName, Date joiningDate) {
		super(id, firstName, lastName);
		this.deptName = deptName;
		this.joiningDate = joiningDate;
	}

	public Employee() {
		super();
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
		return "Employee [id=" + getId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName()
				+ ", deptName=" + deptName + ", joiningDate=" + joiningDate + "]";
	}

}
