package com.example.demo.rest.utils;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class DateTimeUtils {
    public Timestamp getCurrentTime(){
        return new Timestamp(System.currentTimeMillis());
    }
}
