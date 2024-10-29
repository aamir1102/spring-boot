package com.aamir.spring_mvc.thymeleafdemo.controller;

import com.aamir.spring_mvc.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    List<String> countries;

    @Value("${languages}")
    List<String>languages;

    @Value("${systems}")
    List<String>systems;

    @GetMapping("student-form")
    public String studentForm(Model theModel){

        Student theStudent = new Student();

        theModel.addAttribute("student",theStudent);
        theModel.addAttribute("countries",countries);
        theModel.addAttribute("systems",systems);
        theModel.addAttribute("languages",languages);

        return "studentForm";
    }

    @PostMapping("student-conf")
    public String confStudent(@ModelAttribute("student") Student theStudent , Model theModal){

        System.out.println(theStudent);

        return "student-conf";
    }

}
