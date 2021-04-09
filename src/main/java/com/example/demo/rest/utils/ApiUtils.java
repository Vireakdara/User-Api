package com.example.demo.rest.utils;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ApiUtils {
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
