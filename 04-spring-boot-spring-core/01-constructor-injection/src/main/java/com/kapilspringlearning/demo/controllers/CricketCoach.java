package com.kapilspringlearning.demo.controllers;

import com.kapilspringlearning.demo.coaches.Coach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Do daily workout for atleast 15 min";
    }
}
