package com.example.springStudy.chap02;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Member {
    private Long id;
    private String email;
    private String password;
    private String name;
    private LocalDateTime registerDateTime;

    public Member(String email, String password, String name, LocalDateTime regDateTime) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.registerDateTime = regDateTime;
    }

    public void changePassword(String oldPassword, String newPassword){
        if(!password.equals(oldPassword))
            throw new WrongIdPasswordException();
        this.password = newPassword;
    }
}
