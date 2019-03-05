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

}
