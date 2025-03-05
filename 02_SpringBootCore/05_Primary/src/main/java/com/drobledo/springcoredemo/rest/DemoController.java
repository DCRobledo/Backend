package com.drobledo.springcoredemo.rest;

import com.drobledo.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach coach;

    @Autowired
    public DemoController(Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/workout")
    public String GetDailyWorkout()
    {
        return this.coach.GetDailyWorkout();
    }
}
