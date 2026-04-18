package com.kapilspringlearning.demo.restdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestController {
    @GetMapping("/")
     public String HelloWorld() {
         return "Hello World";
     }
     @GetMapping("/workout")
    public String doWorkout(){
        return "Run a 5K daily ";
     }
}
