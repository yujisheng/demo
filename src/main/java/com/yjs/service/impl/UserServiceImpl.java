package com.yjs.service.impl;

import com.yjs.conf.DataSource;
import com.yjs.dao.UserDao;
import com.yjs.entity.UserDo;
import com.yjs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @DataSource("slave")
    @Override
    public List<UserDo> get() {
        return userDao.get();
    }

    @DataSource("master")
    @Override
    public void save(UserDo userDo) {
        userDao.save(userDo);
    }
}
