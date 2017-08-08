package com.hibernate.inheritance.tablepersubclass;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "owners")
@PrimaryKeyJoinColumn(name = "id" /* owners table primary key */, referencedColumnName = "id" /*
																								 * persons
																								 * table
																								 * primary
																								 * key
																								 */)
public class Owners extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6031339161641498097L;

	private Integer stock;

	private String property_value;

	public Owners(String id, String first_name, String last_name, Integer stock, String property_value) {
		super(id, first_name, last_name);
		this.stock = stock;
		this.property_value = property_value;
	}

	public Owners() {

	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getProperty_value() {
		return property_value;
	}

	public void setProperty_value(String property_value) {
		this.property_value = property_value;
	}

	@Override
	public String toString() {
		return "Owners [stock=" + stock + ", property_value=" + property_value + ", id=" + getId() + ", firstName="
				+ getFirstName() + ", lastName=" + getLastName() + "]";
	}

}
