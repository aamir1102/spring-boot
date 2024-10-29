package com.aamir.spring_hibernate;

import com.aamir.spring_hibernate.dao.StudentDAO;
import com.aamir.spring_hibernate.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
//
//		return (runner) ->{
//			System.out.println("Hello Hibernate");
//			save(studentDAO);
//		};
//	}

//	public void save(StudentDAO studentDAO){
//		studentDAO.save(new Student("Steve","Jobs","steve@jobs.com"));
//	}

}
