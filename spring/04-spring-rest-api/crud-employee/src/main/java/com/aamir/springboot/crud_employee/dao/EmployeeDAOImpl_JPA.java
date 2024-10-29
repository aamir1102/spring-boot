package com.aamir.springboot.crud_employee.dao;

import com.aamir.springboot.crud_employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class EmployeeDAOImpl_JPA implements EmployeeDAO{

    EmployeeJPA employeeJPA;

    @Autowired
    EmployeeDAOImpl_JPA(EmployeeJPA employeeJPA){
        this.employeeJPA=employeeJPA;
    }

    @Override
    public List<Employee> findAll() {
        return employeeJPA.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        Optional<Employee> employee=employeeJPA.findById(id);
        return employee.orElse(null);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeJPA.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        employeeJPA.deleteById(id);
    }

    public Employee findByLastName(String name){
        return employeeJPA.findByLastName(name);
    }
}
