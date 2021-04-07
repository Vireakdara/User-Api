package com.example.demo.service;

import com.example.demo.repository.Dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    UserDto insert(UserDto user);
    List<UserDto> select();

}
