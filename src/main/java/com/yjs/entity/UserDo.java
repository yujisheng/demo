package com.yjs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDo implements Serializable {
    private Long user_id;
    private String username;
    private String name;
    private String password;
    private String email;
    private String mobile;

    public UserDo(String username, String name, String password, String email, String mobile) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
    }
}
