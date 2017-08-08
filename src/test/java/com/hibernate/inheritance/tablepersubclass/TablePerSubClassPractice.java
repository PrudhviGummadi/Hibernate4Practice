package com.hibernate.inheritance.tablepersubclass;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class TablePerSubClassPractice {

	@Test
	public void test1() {
		Configuration configuration = new Configuration()
				.configure("com/hibernate/inheritance/tablepersubclass/hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Person person = new Person(null, "David", "clarke");

		session.beginTransaction();
		session.save(person);
		session.getTransaction().commit();

		session.close();
	}

	@Test
	public void test2() {

		Configuration configuration = new Configuration()
				.configure("com/hibernate/inheritance/tablepersubclass/hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Employee employee = new Employee(null, "Michael", "Clarke", "Finance", new Date());

		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();

		session.close();
	}

	@Test
	public void test3() {
		Configuration configuration = new Configuration()
				.configure("com/hibernate/inheritance/tablepersubclass/hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Owners owners = new Owners(null, "Bob", "Marley", 9876, "finance_stock");

		session.beginTransaction();
		session.save(owners);
		session.getTransaction().commit();

		session.close();

	}

	@Test
	public void test4() {
		Configuration configuration = new Configuration()
				.configure("com/hibernate/inheritance/tablepersubclass/hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		List<Object> persons = session.createCriteria(Person.class).list();
		persons.stream().forEach(System.out::println);

		session.close();

	}

}
