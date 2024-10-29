package com.aamir.spring_hibernate.dao;

import com.aamir.spring_hibernate.model.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    Student findByLastName();

    List<Student> findByParameters(String firstName,String lastName);

    List<Student> strictJPQL();

    void update(Student student);

    void remove(int id);
}
