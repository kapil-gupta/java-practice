package com.kapilspringlearning.demo.coaches;

import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Called Basket ball coach";
    }
}
