package com.kapilspringlearning.demo.coaches;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "called football coach";
    }
}
