package com.aamir.springboot.crud_employee.model;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {


    EntityManager entityManager;

    DBInit(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        entityManager.persist(new Employee
                ("Leslie","Andrews","leslie@luv2code.com"));
        entityManager.persist(new Employee
                ("Emma","Baumgarten","lemma@luv2code.com"));
        entityManager.persist(new Employee
                ("Avani","Gupta","lavani@luv2code.com"));
        entityManager.persist(new Employee
                ("Yuri","Petrov","yuri@luv2code.com"));
        entityManager.persist(new Employee
                ("Juan","Vega","juan@luv2code.com"));
    }
}
