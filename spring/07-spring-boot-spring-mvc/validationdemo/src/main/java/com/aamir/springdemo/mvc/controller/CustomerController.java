package com.aamir.springdemo.mvc.controller;

import com.aamir.springdemo.mvc.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showForm(Model theModel){

        Customer theCustomer =new Customer();
//        theCustomer.setFirstName("Aamir");
        theModel.addAttribute("customer" , theCustomer);

        return "customer-form";

    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer,
                              BindingResult theBindingResult){
        if(theBindingResult.hasErrors()){
//            System.out.println(theBindingResult.getAllErrors());
            //messages.properties -> statement got from the line below

            System.out.println(theBindingResult.toString());
            return "customer-form";
        }

        return "customer-confirmation";
    }


}
