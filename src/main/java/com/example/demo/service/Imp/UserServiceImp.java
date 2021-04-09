package com.example.demo.service.Imp;

import com.example.demo.repository.Dto.UserDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto insert(UserDto userDto) {
        boolean isInserted = userRepository.insert(userDto);
        if(isInserted)
            return userDto;
        else
            return null;
    }
}
