package com.kapilspringlearning.demo.coaches;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

public class SwimCoach implements Coach {

    public SwimCoach(){
        System.out.println("Called Constrcutore " + getClass().getSimpleName());
    }
    @PostConstruct
    public void doSomeStuffPostConstruct(){
        System.out.println("Called doSomeStuffPostConstruct " + getClass().getSimpleName());
    }
    @PreDestroy
    public void doSomeStuffPreDestroy(){
        System.out.println("Called doSomeStuffPreDestroy " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Do daily workout for atleast 15 min";
    }
}
