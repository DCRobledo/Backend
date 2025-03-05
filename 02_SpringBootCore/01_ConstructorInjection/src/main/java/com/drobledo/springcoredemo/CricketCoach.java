package com.drobledo.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String GetDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
