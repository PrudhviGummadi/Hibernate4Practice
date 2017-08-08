package com.hibernate.practice.save;

import java.util.Date;

import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Test;

import com.hibernate.practice.model.Student;

/**
 * Save method practice
 * 
 * @author skgummadi
 *
 */
public class CrudPractice {

	@SuppressWarnings("deprecation")
	@Test
	public void testSave() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Student student = new Student();
		student.setCourse("java");
		student.setName("sai");
		student.setCourseEndDate(new Date());

		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();

		student.setCourse("Spring");

		session.close();

	}

	@SuppressWarnings("deprecation")
	@Test
	/**
	 * For DML query without transaction we need to explicitly call the flush
	 * method on session object to execute all the queries.
	 */
	public void testSaveWithoutTransaction() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Student student = new Student();
		student.setCourse("java");
		student.setName("sai prudhvi");
		student.setCourseEndDate(new Date());

		session.save(student);

		student.setCourse("spring");

		session.flush();
		session.close();

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSave1() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Student student = new Student();
		student.setCourse("java");
		student.setName("Prudhvi");
		student.setCourseEndDate(new Date());

		session.beginTransaction();
		session.save(student);
		student.setCourse("Spring");
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testUpdate1() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		session.beginTransaction();
		Student student = (Student) session.get(Student.class, 1);
		System.out.println("Fetched the student with id 1: " + student);
		student.setCourse("Spring");
		session.getTransaction().commit();

		session.close();
	}

	@Test
	public void testUpdate2() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Student student = (Student) session.get(Student.class, 1);
		System.out.println("Before: " + student);

		student.setCourse("java");

		session.beginTransaction();
		session.update(student);
		session.getTransaction().commit();

		student = (Student) session.get(Student.class, 1);
		System.out.println("After: " + student);
		session.close();
	}

	@Test
	public void testDelete() {
		Configuration config = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();

		session.beginTransaction();

		Student student = new Student();
		student.setName("Bob");
		student.setCourse("python");
		student.setCourseEndDate(new Date());

		session.save(student);

		session.getTransaction().commit();

		session.beginTransaction();

		session.delete(student);

		session.getTransaction().commit();

		Object object = session.get(Student.class, student.getId());
		Assert.assertNull(object);
		session.close();

	}

	@Test
	public void testSaveOrUpdate() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		session.beginTransaction();

		Student student = new Student();
		student.setName("Bob");
		student.setCourse("python");
		student.setCourseEndDate(new Date());

		session.saveOrUpdate(student);
		session.getTransaction().commit();

		System.out.println("Before student:" + session.get(Student.class, student.getId()));

		session.beginTransaction();
		student.setCourse("Java");
		session.saveOrUpdate(student);
		session.getTransaction().commit();

		System.out.println("After Student:" + session.get(Student.class, student.getId()));

		session.close();

	}

	@Test(expected = NonUniqueObjectException.class)
	public void testUpdate3() {
		Configuration config = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();

		Student student = (Student) session.get(Student.class, 3);
		Student student1 = new Student();
		student1.setId(3);
		student1.setName("Mark");
		student1.setCourse("python");
		student1.setCourseEndDate(new Date());

		session.beginTransaction();

		session.update(student1);

		session.getTransaction().commit();

		session.close();

	}

	@Test
	public void testMerge() {
		Configuration config = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();

		Student student = (Student) session.get(Student.class, 3);
		Student student1 = new Student();
		student1.setId(3);
		student1.setName("David");
		student1.setCourse("python");
		student1.setCourseEndDate(new Date());

		System.out.println("Before Student: " + student);

		session.beginTransaction();

		session.merge(student1);

		session.getTransaction().commit();

		System.out.println("After Student: " + session.load(Student.class, 3));

		session.close();

	}

}
