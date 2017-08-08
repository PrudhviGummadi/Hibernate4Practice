package com.hibernate.inheritance.tableperconcreteclass;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class TablePerConcreteClassPractice {

	@Test
	public void test1() {
		Configuration configuration = new Configuration()
				.configure("com/hibernate/inheritance/tableperconcreteclass/hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Employee employee = new Employee(null, "David", "Clarke", "sales", new Date());

		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();

		session.close();
	}

	@Test
	public void test2() {
		Configuration configuration = new Configuration()
				.configure("com/hibernate/inheritance/tableperconcreteclass/hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Person person = new Person(null, "Michale", "Clarke");

		session.beginTransaction();
		session.save(person);
		session.getTransaction().commit();

		session.close();

	}

	@Test
	public void test3() {
		Configuration configuration = new Configuration()
				.configure("com/hibernate/inheritance/tableperconcreteclass/hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Owners owner = new Owners(null, "Bob", "Marley", 1000, 50000);
		session.beginTransaction();
		session.save(owner);
		session.getTransaction().commit();
		session.close();
	}

}
