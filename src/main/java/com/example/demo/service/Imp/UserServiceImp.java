package com.example.demo.service.Imp;

import com.example.demo.repository.Dto.UserDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto insert(UserDto user) {
        boolean isInserted = userRepository.insert(user);
        if (isInserted)
            return user;
        else
            return null;

    }

    @Override
    public List<UserDto> select() {
        return userRepository.select();
    }


}
