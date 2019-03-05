package com.yjs.dao;

import com.yjs.entity.UserDo;

import java.util.List;

public interface UserDao {
    public List<UserDo> get();

    public void save(UserDo userDo);
}
