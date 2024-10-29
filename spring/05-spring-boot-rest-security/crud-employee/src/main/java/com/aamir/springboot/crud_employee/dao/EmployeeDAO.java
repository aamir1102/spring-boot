package com.aamir.springboot.crud_employee.dao;

import com.aamir.springboot.crud_employee.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(Integer id);

    Employee save(Employee employee);

    void deleteById(Integer id);

}
