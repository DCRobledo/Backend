package com.drobledo.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String HelloWorld() {
        return "Hello " + coachName + ", from " + teamName + " team!";
    }
}
