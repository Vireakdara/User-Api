package com.example.demo.repository;

import com.example.demo.repository.Dto.UserDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    @Insert("INSERT INTO stdy.tbl_users (user_name, user_pwd, type) " +
            "VALUES (#{user_name}, #{user_pwd}, #{type})")
    boolean insert(UserDto user);

    @Select("SELECT * FROM stdy.tbl_users")
    List<UserDto> select();




}
