package com.kapilspringlearning.demo.coaches;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
/**
 * since we made this primary, so untill we specify specific this will be considered as default bean
 */
@Primary
public class TennisCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "called tennis coach";
    }
}
