package com.aamir.spring_overview.controller;

import com.aamir.spring_overview.model.Coach;
import com.aamir.spring_overview.model.CricketCoach;
import com.aamir.spring_overview.model.SingleTon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;
    @Value("${server.port}")
    private String port;

    @GetMapping("/hello")
    public String sayHello(){
        return teamName+" "+coachName+" from port number -> "+port;
    }

    Coach theCoach,theAnotherCoach;


    SingleTon theSingle,anotherSingle;



    @Autowired
    DemoController(@Qualifier("cricketCoach") Coach coach,
                   @Qualifier("cricketCoach") Coach anotherCoach,
                   SingleTon theSingle, SingleTon anotherSingle){
        theCoach=coach;
        theAnotherCoach=anotherCoach;this.theSingle=theSingle;
        this.anotherSingle=anotherSingle;

    }

    Coach theBlueLock;
    @Autowired
    public void lockSetter(@Qualifier("blueLock") Coach theBlueLock){
        this.theBlueLock=theBlueLock;
    }


    @GetMapping("/daily")
    public String myCoachAssistance(){
        return theCoach.getDailyWorkOut();
    }

    @GetMapping("/check")
    public boolean checkerFn() {
        return theCoach==theAnotherCoach;
    }

    @GetMapping("/single")
    public String protoChecker(){

        theSingle.setA(10);
        anotherSingle.setA(20);

        return anotherSingle.getA()+"-->"+theSingle.getA();
    }

    @GetMapping("/lock")
    public String blueLock(){
        return theBlueLock.getDailyWorkOut();
    }
}
