package com.aamir.springboot.crud_employee.service;

import com.aamir.springboot.crud_employee.dao.EmployeeDAO;
import com.aamir.springboot.crud_employee.dao.EmployeeDAOImpl;
import com.aamir.springboot.crud_employee.dao.EmployeeDAOImpl_JPA;
import com.aamir.springboot.crud_employee.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    EmployeeDAOImpl_JPA employeeDAO;

    @Autowired
    EmployeeService(EmployeeDAOImpl_JPA employeeDAO){
        this.employeeDAO=employeeDAO;
    }

    EntityManager entityManager;

    @Autowired
    void setEntityManager(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

    public Employee findById(Integer id){
        return employeeDAO.findById(id);
    }

    @Transactional
    public Employee save(Employee employee){
        return employeeDAO.save(employee);
    }

    @Transactional
    public void deleteById(Integer id){
        employeeDAO.deleteById(id);
    }


    @Transactional
    public void delete(Employee employee){
        entityManager.remove(employee);
    }

    public Employee findByLastName(String name){
        return employeeDAO.findByLastName(name);
    }

}
