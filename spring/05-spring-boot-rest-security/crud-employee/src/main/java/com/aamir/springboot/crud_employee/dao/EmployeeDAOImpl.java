package com.aamir.springboot.crud_employee.dao;

import com.aamir.springboot.crud_employee.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    EntityManager entityManager;

    @Autowired
    EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }


    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager
                .createQuery("SELECT e FROM Employee e",Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(Integer id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(Integer id) {
        Employee employee = findById(id);
        entityManager.remove(employee);
    }


}
