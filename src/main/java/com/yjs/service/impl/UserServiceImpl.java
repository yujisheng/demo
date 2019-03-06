package com.yjs.service.impl;

import com.yjs.dao.UserDao;
import com.yjs.entity.UserDo;
import com.yjs.service.UserService;
import com.yjs.utils.DataSourceMark;
import com.yjs.utils.DataSourceNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @DataSourceMark(value = DataSourceNames.SLAVE)
    @Override
    public List<UserDo> get() {
        return userDao.get();
    }

    @DataSourceMark(value = DataSourceNames.Master)
    @Override
    public void save(UserDo userDo) {
        userDao.save(userDo);
    }
}
