package com.hibernate.practice.save;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Ignore;
import org.junit.Test;

import com.hibernate.practice.model.Student;

@SuppressWarnings("unchecked")
public class HQLBasicPractice {

	/**
	 * Select all students from student table using hql
	 * 
	 * select * from student;
	 */
	@Test
	public void testHQLSelectAll() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		// Here Student is not the table name. It is the actual Student class
		// name. So it should be camel case
		Query query = session.createQuery("from Student");

		// Actual query to DB will be fired in below statement
		List<Student> students = query.list();

		students.stream().forEach(System.out::println);

		session.close();
	}

	/***
	 * Select student with given id
	 * 
	 * select * from student where id=1;
	 */
	@Test
	public void testSelectStudentById() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Query query = session.createQuery("from Student stud where stu.id=:id");
		query.setInteger("id", 1);
		Student student = (Student) query.uniqueResult();

		System.out.println(student);

		session.close();
	}

	/**
	 * select name , course from student;
	 */
	@Test
	public void testSelectColumnsFromStudent() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		String hqlQuery = "select stu.name, stu.course from Student stu";

		Query query = session.createQuery(hqlQuery);
		List<Object[]> students = query.list();

		students.stream().forEach(s -> {
			System.out.println(s[0] + ", " + s[1]);
		});

		session.close();

	}

	/**
	 * select * from student where name like 'S%';
	 */
	@Test
	public void testNameLike() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		String filter = "s%";
		String hqlQuery = "from Student stu where stu.name like :filter";

		Query query = session.createQuery(hqlQuery);
		query.setParameter("filter", filter);

		List<Student> students = query.list();

		students.stream().forEach(System.out::println);

		session.close();

	}

	/**
	 * select * from student where name like 's%' and order by course DESC;
	 */
	@Test
	public void testHql1() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		String queryString = "from Student stu where stu.name like :name order by stu.course desc";

		Query query = session.createQuery(queryString);
		query.setParameter("name", "s%");

		List<Student> students = query.list();

		students.stream().forEach(System.out::println);

		session.close();

	}

	/***
	 * select * from student where name='sai' and course='java';
	 */
	@Test
	public void testHql2() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		String queryString = "from Student stu where stu.name= :name and stu.course= :course";
		List<Student> students = session.createQuery(queryString).setParameter("name", "sai")
				.setParameter("course", "java").list();

		students.stream().forEach(System.out::println);

		session.close();

	}

	/**
	 * select * from student where name='sai' or course='java';
	 */
	@Test
	public void testHql3() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		String queryString = "from Student stu where stu.name= :name or stu.course= :course";
		Query query = session.createQuery(queryString);
		query.setParameter("name", "sai");
		query.setParameter("course", "java");

		List<Student> students = query.list();

		students.stream().forEach(System.out::println);

		session.close();

	}

	/***
	 * UPDATE STUDENT SET COURSE = 'NEW_COURSE_VALUE' WHERE NAME = 'Jill'
	 */
	@Test
	public void testHql4() {

		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		String queryString = "update Student stu set stu.course=:course where stu.name=:name";

		Query query = session.createQuery(queryString);
		query.setParameter("course", "java");
		query.setParameter("name", "prudhvi");

		session.beginTransaction();

		int i = query.executeUpdate();

		System.out.println("No of rows updated: " + i);

		session.getTransaction().commit();

		session.close();

	}

	/**
	 * select * from student where name='sai'
	 */
	@Test
	public void testHql5() {

		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		String queryString = "from Student stu where stu.name=:name";
		Query query = session.createQuery(queryString);
		query.setParameter("name", "prudhvi");

		Student student = (Student) query.uniqueResult();

		System.out.println(student);

		session.close();
	}

	/**
	 * delete from student where name ='abc';
	 */
	@Test
	@Ignore
	public void testDelete() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		String queryString = "delete from Student  stu where name=:name";
		Query query = session.createQuery(queryString);
		query.setParameter("name", "David");

		session.beginTransaction();

		int i = query.executeUpdate();
		System.out.println("No of rows deleted: " + i);

		session.getTransaction().commit();

		queryString = "from Student stu where stu.name=:name";
		query = session.createQuery(queryString);
		query.setParameter("name", "David");

		session.close();

	}

	/***
	 * select count(*), sum(id), avg(id), max(id), min(id) from student;
	 */
	@Test
	public void testAggregrateFunctions() {

		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		String queryString = "select count(id), sum(id), avg(id), max(id), min(id) from Student";
		Query query = session.createQuery(queryString);
		List<Object[]> resultSet = query.list();

		resultSet.stream().forEach(row -> {
			System.out.println(row[0] + ", " + row[1] + ", " + row[2] + ", " + row[3] + ", " + row[4] + ".");
		});

		session.close();

	}

	/**
	 * select id, sum(id), avg(id) from student group by id;
	 */
	@Test
	public void testAggregrateFunctions1() {

		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		String queryString = "select stu.id, sum(stu.id), avg(stu.id) from Student stu group by stu.id";
		Query query = session.createQuery(queryString);
		List<Object[]> resultSet = query.list();

		resultSet.stream().forEach(row -> {
			System.out.println(row[0] + ", " + row[1] + ", " + row[2]);
		});

	}

	/**
	 * select sum(id), avg(id) from student group by course;
	 */
	@Test
	public void testAggregrateFunctions2() {

		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		String queryString = "select sum(stu.id), avg(stu.id) from Student stu group by course";
		Query query = session.createQuery(queryString);

		List<Object[]> resultSet = query.list();

		resultSet.stream().forEach(row -> {
			System.out.println(row[0] + ", " + row[1]);
		});

		session.close();

	}

	/**
	 * select distinct course from student;
	 */
	@Test
	public void testHql6() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		String queryString = "select distinct stu.course from Student stu";
		Query query = session.createQuery(queryString);
		List<String> resultSet = query.list();

		resultSet.stream().forEach(System.out::println);

		session.close();

	}

	/**
	 * select * from student where id <>1;
	 */
	@Test
	public void testHql7() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		String queryString = "from Student stu where stu.id<>:id";
		Query query = session.createQuery(queryString);
		query.setParameter("id", 1);

		List<Student> students = query.list();

		students.stream().forEach(System.out::println);

		session.close();

	}

	/**
	 * select * from student where id in (?,?);
	 */
	@Test
	public void testHql8() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		String queryString = "from Student where id in (:ids)";
		Query query = session.createQuery(queryString);
		query.setParameterList("ids", Arrays.asList(1, 4));

		List<Student> students = query.list();

		students.stream().forEach(System.out::println);

		session.close();

	}

}
