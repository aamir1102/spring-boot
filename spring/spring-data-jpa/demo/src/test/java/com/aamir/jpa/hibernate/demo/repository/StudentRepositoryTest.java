package com.aamir.jpa.hibernate.demo.repository;

import com.aamir.jpa.hibernate.demo.DemoApplication;
import com.aamir.jpa.hibernate.demo.entity.Passport;
import com.aamir.jpa.hibernate.demo.entity.Student;
import jakarta.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

// replaced @RunWith with @ExtendWith
// replaced SpringRunner.class with SpringExtension.class
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager em;

	//Session & Session Factory

	
	//EntityManager & Persistence Context
	//Transaction
	
	@Test
	public void someTest() {
		repository.someOperationToUnderstandPersistenceContext();
	}


	@Test
	@Transactional
	//Since we are doing lazy fetching if we don't use @Transactional the hibernate session gets killed
	//after fetching the student details and passport details are not fetched.
	//We will get an error at -> student.getPassport();
	//When we use @Transactional the session lives till the end of the method.
	public void retrieveStudentAndPassportDetails() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student -> {}", student);
		logger.info("passport -> {}",student.getPassport());
	}

	@Test
	@Transactional
	public void retrievePassportAndAssociatedStudent() {
		Passport passport = em.find(Passport.class, 40001L);
		logger.info("passport -> {}", passport);
		logger.info("student -> {}", passport.getStudent());
	}

	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		Student student = em.find(Student.class, 20001L);

		logger.info("student -> {}", student);
		logger.info("courses -> {}", student.getCourses());
	}
}