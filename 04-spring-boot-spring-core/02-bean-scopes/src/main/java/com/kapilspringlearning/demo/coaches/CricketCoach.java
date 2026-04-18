package com.kapilspringlearning.demo.coaches;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("CricketCoach Initialized");
    }
    @Override
    public String getDailyWorkout() {
        return "Called Cricket Coach";
    }
}
