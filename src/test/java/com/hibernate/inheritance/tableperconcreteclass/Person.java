package com.hibernate.inheritance.tableperconcreteclass;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "person")
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7096865075449312348L;

	private Integer id;

	private String firstName;

	private String lastName;

	public Person(Integer id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Person() {
		super();
	}

	@Id
	@TableGenerator(name = "person_table", table = "sequences", pkColumnName = "seq_name", valueColumnName = "seq_num", pkColumnValue = "person_sequence")
	@GeneratedValue(generator = "person_table", strategy = GenerationType.TABLE)
	/*
	 * Here the generation strategy should be by table with own table generator.
	 * Create a sequences table in DB seq_name and seq_num as columns and
	 * inserted default values
	 */
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
