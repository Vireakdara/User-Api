package com.example.demo.service.Imp;

import com.example.demo.repository.Dto.UserTableDto;
import com.example.demo.repository.UserTableRepository;
import com.example.demo.service.UserTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTableServiceImp implements UserTableService {
    private UserTableRepository userTableRepository;

    @Autowired
    public void setUserRepository(UserTableRepository userTableRepository) {
        this.userTableRepository = userTableRepository;
    }

    @Override
    public UserTableDto insert(UserTableDto user) {
        boolean isInserted = userTableRepository.insert(user);
        if (isInserted)
            return user;
        else
            return null;

    }

    @Override
    public List<UserTableDto> select() {
        return userTableRepository.select();
    }


}
