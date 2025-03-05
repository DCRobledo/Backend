package com.drobledo.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    @Override
    public String GetDailyWorkout() {
        return "Run a hard 5k!";
    }
}
