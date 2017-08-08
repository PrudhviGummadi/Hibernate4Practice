package com.hibernate.criteria.practice;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.hibernate.practice.model.Student;

@SuppressWarnings("unchecked")
public class CriteriaPractice {

	/**
	 * select * from student;
	 */
	@Test
	public void getAllStudents() {
		Configuration config = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Student.class);
		List<Student> students = criteria.list();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	/**
	 * select * from student where id=1;
	 */
	@Test
	public void testCriteria1() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Student.class);
		Criterion idCriterion = Restrictions.eq("id", 1);
		criteria.add(idCriterion);

		Student student = (Student) criteria.uniqueResult();
		System.out.println(student);

		session.close();

	}

	/**
	 * 
	 */
	@Test
	public void testCriteria15() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Student student = new Student();
		student.setCourse("Spring");
		student.setName("David");
		student.setCourseEndDate(new Date());

		session.beginTransaction();

		session.save(student);
		session.getTransaction().commit();

		session.close();

	}

	/***
	 * select * from student where id=1;
	 */
	@Test
	public void testCriteria2() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Student.class);
		Criterion idCriterion = Restrictions.idEq(1);
		criteria.add(idCriterion);

		Student student = (Student) criteria.uniqueResult();
		System.out.println(student);

		session.close();

	}

	/**
	 * select * from Student where name=?;
	 */
	@Test
	public void testCriteria3() {

		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		// Method1
		Criteria criteria = session.createCriteria(Student.class);
		Criterion nameCriterion = Restrictions.eq("name", "sai");
		criteria.add(nameCriterion);

		List<Student> students = criteria.list();
		students.stream().forEach(System.out::println);

		session.close();

	}

	/**
	 * select * from student where name like '%i';
	 */
	@Test
	public void testCriteria4() {

		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Student.class);
		Criterion nameCriterion = Restrictions.like("name", "%i");
		criteria.add(nameCriterion);

		List<Student> students = criteria.list();

		students.stream().forEach(System.out::println);

		session.close();

	}

	/**
	 * 
	 * one approach
	 * 
	 * select * from student where id =? and name=?
	 */
	@Test
	public void testCriteria5() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Student.class);
		Criterion idCriterion = Restrictions.idEq(1);
		Criterion namCriterion = Restrictions.eq("name", "sai");

		Criterion criterion = Restrictions.and(idCriterion, namCriterion);

		criteria.add(criterion);

		List<Student> students = criteria.list();

		students.stream().forEach(System.out::println);

		session.close();

	}

	/**
	 * 
	 * second approach
	 * 
	 * select * from student where id =? and name=?
	 */
	@Test
	public void testCriteria6() {

		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Student.class);
		Criterion idCriterion = Restrictions.idEq(1);
		Criterion namCriterion = Restrictions.eq("name", "sai");

		criteria.add(idCriterion);
		criteria.add(namCriterion);

		List<Student> students = criteria.list();

		students.stream().forEach(System.out::println);

		session.close();

	}

	/**
	 * 
	 * third approach
	 * 
	 * select * from student where id =? and name=?
	 */
	@Test
	public void testCriteria7() {

		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Student.class);

		Map<String, Object> criterionMap = new HashMap<>();
		criterionMap.put("id", 1);
		criterionMap.put("name", "sai");

		Criterion criterion = Restrictions.allEq(criterionMap);
		criteria.add(criterion);

		List<Student> students = criteria.list();

		students.stream().forEach(System.out::println);

		session.close();

	}

	/**
	 * select * from student where id=? and (name like ? or name like ?)
	 */
	@Test
	public void testCriteria8() {

		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Student.class);
		Criterion idCriterion = Restrictions.idEq(1);
		Criterion name1Criterion = Restrictions.like("name", "%i");
		Criterion name2Criterion = Restrictions.like("name", "s%");

		Criterion orCriterion = Restrictions.or(name1Criterion, name2Criterion);
		Criterion finalCriterion = Restrictions.and(idCriterion, orCriterion);

		criteria.add(finalCriterion);

		Student student = (Student) criteria.uniqueResult();

		System.out.println(student);

		session.close();

	}

	/**
	 * select * from student where name like ? order by id;
	 */
	@Test
	public void testCriteria9() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Student.class);
		Criterion nameCriterion = Restrictions.like("name", "%i");

		Order orderCriterion = Order.desc("id");

		criteria.add(nameCriterion);
		criteria.addOrder(orderCriterion);

		List<Student> students = criteria.list();

		students.stream().forEach(System.out::println);

		session.close();

	}

	/**
	 * select name from Student;
	 */
	@Test
	public void testCriteria10() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Student.class);
		Projection courseProjection = Projections.property("name");
		criteria.setProjection(courseProjection);

		List<String> courseArray = criteria.list();

		courseArray.stream().forEach(System.out::println);

		session.close();
	}

	/**
	 * select name, id from student where course=java order by id desc;
	 */
	@Test
	public void testCriterion10() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Student.class);
		Criterion courseCriterion = Restrictions.eq("course", "java");

		ProjectionList projectionsList = Projections.projectionList();
		projectionsList.add(Projections.property("name"));
		projectionsList.add(Projections.property("id"));

		criteria.add(courseCriterion);
		criteria.addOrder(Order.desc("id"));
		criteria.setProjection(projectionsList);

		List<Object[]> array = criteria.list();
		array.stream().forEach(row -> {
			System.out.println("name: " + row[0] + " ,id: " + row[1]);
		});

		session.close();

	}

	/**
	 * select count(*) from student
	 */
	@Test
	public void testCriteria11() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Student.class);
		criteria.setProjection(Projections.rowCount());

		Long rowCount = (Long) criteria.uniqueResult();

		System.out.println("No of rows: " + rowCount);

		session.close();

	}

	/**
	 * select sum(id), course from student group by course;
	 */
	@Test
	public void testCriteria12() {
		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Student.class);

		ProjectionList list = Projections.projectionList();
		list.add(Projections.groupProperty("course"));
		list.add(Projections.sum("id"));

		criteria.setProjection(list);

		List<Object[]> array = criteria.list();

		array.stream().forEach(row -> {
			System.out.println("Group BY course: " + row[0] + " and enrolled students are: " + row[1]);
		});

		session.close();

	}

	/**
	 * select sum(id) from student;
	 */
	@Test
	public void testCriteria13() {

		Configuration configuration = new Configuration().configure("hibernate-annotation.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Criteria criteria = session.createCriteria(Student.class);

		Projection sumProjection = Projections.sum("id");
		criteria.setProjection(sumProjection);

		Long sum = (Long) criteria.uniqueResult();

		System.out.println("Total sum of ids in student table is: " + sum);

		session.close();

	}

}
