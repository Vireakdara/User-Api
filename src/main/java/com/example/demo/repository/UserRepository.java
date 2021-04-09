package com.example.demo.repository;

import com.example.demo.repository.Dto.UserDto;
import com.example.demo.repository.provider.UserProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    @InsertProvider(type = UserProvider.class, method = "insertUserSql")

    boolean insert(UserDto userDto);


}
