package com.example.demo.rest.request;

public class UserRequestModel {
    private String user_name;
    private String user_pwd;
    private String type;

    public UserRequestModel() {
    }

    public UserRequestModel(String user_name, String user_pwd, String type) {
        this.user_name = user_name;
        this.user_pwd = user_pwd;
        this.type = type;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "UserRequestModel{" +
                "user_name='" + user_name + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
