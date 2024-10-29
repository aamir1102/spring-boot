package com.aamir.spring_hibernate.model;

import com.aamir.spring_hibernate.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    StudentDAO studentDAO;

    @Autowired
    Runner(StudentDAO studentDAO){
        this.studentDAO=studentDAO;
    }

    @Override
    public void run(String... args) throws Exception {
        save();
//        findById(2);
//        findAll();
//        findByLastName();
//        findByParameters();
//        strictJPQL();

//        update();
        remove(2);
    }

    public void save(){
        studentDAO.save(new Student
                ("Elon","Musk","elon@tesla.com"));
        studentDAO.save(new Student
                ("Mark","Zuckerberg","mark@facebook.com"));
        studentDAO.save(new Student
                ("Steve","Jobs","steve@apple.com"));
    }

    public Student findById(Integer id){
        Student student = studentDAO.findById(id);
//        System.out.println(student);

        return student;
    }

    public void findAll(){
        List<Student>students=studentDAO.findAll();
        students.forEach((student) -> {System.out.println(student);});
    }

    public void findByLastName(){
        System.out.println("Find by lastName -> "+studentDAO.findByLastName());
    }

    public void findByParameters(){
        List<Student> students = studentDAO.findByParameters("Elon","Jobs");
        System.out.println("Parameters --> ");
        students.forEach((student) -> {System.out.println(student);});
    }


    public void strictJPQL(){
        System.out.println("List Of All Students --> ");
        List<Student> students=studentDAO.strictJPQL();

        students.forEach((student) -> {System.out.println(student);});
    }

    public void update(){
        Student student = findById(2);
        student.setEmail("mark@meta.com");

        studentDAO.update(student);

        System.out.println(findById(2));


    }

    public void remove(int id){
        findAll();
        System.out.println("----------------------------------------------");
        studentDAO.remove(id);

        findAll();
    }

}
