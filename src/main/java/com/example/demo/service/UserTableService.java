package com.example.demo.service;

import com.example.demo.repository.Dto.UserTableDto;

import java.util.List;

public interface UserTableService {
    UserTableDto insert(UserTableDto user);
    List<UserTableDto> select();

}
