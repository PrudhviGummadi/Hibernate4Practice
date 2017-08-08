package com.hibernate.inheritance.tableperclass;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class TablePerClassPractice {

	/**
	 * save student
	 */
	@Test
	public void test1() {

		Configuration configuration = new Configuration()
				.configure("com/hibernate/inheritance/tableperclass/hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Person person = new Person();
		person.setLastName("clarke");
		person.setFirstName("David");

		session.beginTransaction();

		Integer id = (Integer) session.save(person);
		System.out.println("Person saved with id: " + id);

		session.getTransaction().commit();

		session.close();

	}

	/**
	 * save Employee
	 */
	@Test
	public void test2() {

		Configuration configuration = new Configuration()
				.configure("com/hibernate/inheritance/tableperclass/hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Employee employee = new Employee();
		employee.setFirstName("Michale");
		employee.setLastName("Clarke");
		employee.setDeptName("Sales");
		employee.setJoiningDate(new Date());

		session.beginTransaction();

		Integer id = (Integer) session.save(employee);
		System.out.println("Employee saved with id: " + id);
		session.getTransaction().commit();

		session.close();

	}

	/**
	 * select * from person
	 */
	@Test
	public void test3() {

		Configuration configuration = new Configuration()
				.configure("com/hibernate/inheritance/tableperclass/hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Employee.class);
		List<Employee> employees = criteria.list();
		employees.stream().forEach(System.out::println);

		criteria = session.createCriteria(Person.class);
		List<Person> persons = criteria.list();
		persons.stream().forEach(System.out::println);

		session.close();

	}

}
