package com.example.demo.repository;

import com.example.demo.repository.Dto.UserTableDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTableRepository {
    // Normal MyBatis
    @Insert("INSERT INTO tbl_users (user_name, user_pwd, type) " +
            "VALUES (#{user_name}, #{user_pwd}, #{type})")
    boolean insert(UserTableDto user);

    @Select("SELECT * FROM tbl_users")
    List<UserTableDto> select();

}
