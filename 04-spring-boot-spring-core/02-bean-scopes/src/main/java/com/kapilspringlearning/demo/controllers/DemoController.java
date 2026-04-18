package com.kapilspringlearning.demo.controllers;

import com.kapilspringlearning.demo.coaches.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final Coach myCoach;
    private final Coach anotherCoach;

    /**
     *  1. Since we made TennisCoach primary and used @qualifier here so that will take precedence  over primary
     *  and football will be autowired
     *  2. We have decalred CricektCoach as protype scope that means each time it is injected
     *  a new object will be created, whereas by default spring has singleton objects
     */
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach coach1,
                          @Qualifier("cricketCoach") Coach coach2){
        myCoach = coach1;
        anotherCoach = coach2;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
    @GetMapping("/check")
    public String checkProtoTypeObjects(){
        // it will be false since different objects are created
        System.out.println( " Coach 1 == Coach 2 => "  + (myCoach == anotherCoach));
        return "checked ";
    }
}
