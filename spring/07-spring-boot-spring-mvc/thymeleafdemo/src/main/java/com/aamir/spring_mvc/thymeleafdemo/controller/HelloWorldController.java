package com.aamir.spring_mvc.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm(){
        return "login-form";
    }

    @GetMapping("/processForm")
    public String processForm(){
        return "formdata";
    }

    @GetMapping("/processFormVersion2")
    public String processFormVersion2(HttpServletRequest request, Model theModel){

        String name= request.getParameter("studentName");
        name=name.toUpperCase();

        theModel.addAttribute("message" , "Welcome , Your Login Id-> "+name);

        return "formdataVersion2";
    }

    @PostMapping("/processFormVersion3")
    public String processFormVersion3(@RequestParam("studentName") String name, Model theModel){

        name=name.toLowerCase();
        theModel.addAttribute("message" , "Your name from version 3 "+name+" !!!!");

        return "formdataVersion2";
    }
}
