package com.java.application.dto;

import lombok.Data;

import java.util.List;

@Data
public class PhoneBookDto {

    private Long id;

    private List<UserDto> phoneBookUsers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<UserDto> getPhoneBookUsers() {
        return phoneBookUsers;
    }

    public void setPhoneBookUsers(List<UserDto> phoneBookUsers) {
        this.phoneBookUsers = phoneBookUsers;
    }
}
