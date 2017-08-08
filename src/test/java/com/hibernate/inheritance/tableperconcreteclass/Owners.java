package com.hibernate.inheritance.tableperconcreteclass;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@AttributeOverrides({ @AttributeOverride(name = "firstName", column = @Column(name = "first_name")),
		@AttributeOverride(name = "lastName", column = @Column(name = "last_name")),
		@AttributeOverride(name = "id", column = @Column(name = "id")) })
// firstName=property name in person class and first_name=column name in owners
// table
// lastName=property name in person class and last_name=column name in owners
// class
@Table(name = "owners")
public class Owners extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6908379800986009491L;

	private Integer stock;

	private Integer property_value;

	public Owners(Integer id, String firstName, String lastName, Integer stock, Integer property_value) {
		super(id, firstName, lastName);
		this.stock = stock;
		this.property_value = property_value;
	}

	public Owners() {
		super();
	}

	@Column(name = "stock")
	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Column(name = "property_value")
	public Integer getProperty_value() {
		return property_value;
	}

	public void setProperty_value(Integer property_value) {
		this.property_value = property_value;
	}

	@Override
	public String toString() {
		return "Owners [id=" + getId() + ", first_name=" + getFirstName() + ", last_name=" + getLastName() + ", stock="
				+ stock + ", property_value=" + property_value + "]";
	}

}
