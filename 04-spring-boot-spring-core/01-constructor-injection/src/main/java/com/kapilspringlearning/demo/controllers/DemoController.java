package com.kapilspringlearning.demo.controllers;

import com.kapilspringlearning.demo.coaches.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final Coach myCoach;

    @Autowired
    public DemoController(Coach coach){
        myCoach = coach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
