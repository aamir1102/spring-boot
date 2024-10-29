package com.aamir.spring_mvc.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String helloFn(Model theModel){
        theModel.addAttribute("theDate",java.time.LocalDateTime.now());

        return "helloWorld";
    }
}
