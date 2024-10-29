package com.aamir.springboot.crud_employee.controller;

import com.aamir.springboot.crud_employee.exception.EmployeeException;
import com.aamir.springboot.crud_employee.model.Employee;
import com.aamir.springboot.crud_employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    void setEmployeeService(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable Integer id){
        Employee employee=employeeService.findById(id);
        if(employee==null)
            throw new EmployeeException("The employee with id -> "+id+" doesn't exist");
        return employee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteById(@PathVariable Integer id){
        Employee employee = findById(id);

        employeeService.deleteById(id);
        return "Employee deleted !!";
    }
    @DeleteMapping("/employees/emp/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        Employee employee = findById(id);

        if(employee==null)
            throw new EmployeeException("The employee with id -> "+id+" doesn't exist");
        employeeService.delete(employee);

        return "Employee deleted !!";

    }

    @GetMapping("/employees/last/{name}")
    public Employee findByLastName(@PathVariable String name){
        return employeeService.findByLastName(name);
    }



}
