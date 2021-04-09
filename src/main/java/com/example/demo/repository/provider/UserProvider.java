package com.example.demo.repository.provider;

import org.apache.ibatis.jdbc.SQL;

public class UserProvider {

    public String insertUserSql(){
        return new SQL(){{
            // Define SQL Statement
            INSERT_INTO("users");
            VALUES("user_id", "#{userId}");
            VALUES("username","#{username}");
            VALUES("password","#{password}");
        }}.toString();
    }
}
