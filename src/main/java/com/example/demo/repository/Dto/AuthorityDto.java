package com.example.demo.repository.Dto;

public class AuthorityDto {

    private int id;
    private String name;

    public AuthorityDto() {
    }

    public AuthorityDto(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AuthorityDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
