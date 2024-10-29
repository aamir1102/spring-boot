package com.aamir.springboot.crud_employee.dao;

import com.aamir.springboot.crud_employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJPA extends JpaRepository<Employee, Integer> {

    Employee findByLastName(String name);
}
