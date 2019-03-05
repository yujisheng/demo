package com.yjs.service;

import com.yjs.entity.UserDo;

import java.util.List;

public interface UserService {
    public List<UserDo> get();

    public void save(UserDo userDo);
}
