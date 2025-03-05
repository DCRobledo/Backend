package com.drobledo.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String GetDailyWorkout() {
        return "Practice your backhand volley";
    }
}
