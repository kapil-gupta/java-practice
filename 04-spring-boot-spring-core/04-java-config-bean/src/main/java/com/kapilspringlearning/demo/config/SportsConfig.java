package com.kapilspringlearning.demo.config;

import com.kapilspringlearning.demo.coaches.Coach;
import com.kapilspringlearning.demo.coaches.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportsConfig {

    /**
     * This is manual process to create a bean for spring
     * this is mainly used for 3 party libraries since we can not modify them
     * and wanted to use those in our spring app as spring bean
     * hence we need to initialize them as bean and use through the application
     * for Example AWS s3 Client
     *
     */
    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
