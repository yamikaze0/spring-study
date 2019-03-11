package org.yamikaze.spring.study.tx.annotation.impl;

import org.springframework.stereotype.Service;
import org.yamikaze.dao.IUserDao;
import org.yamikaze.model.User;

import javax.annotation.Resource;

/**
 * @author yamikaze
 * @version 1.0.0
 * @date 2018/3/26 9:59
 */
@Service("testAddUser")
public class TestAddUser {

    @Resource
    private IUserDao userDao;

    public void addUser(User user) {
        userDao.save(user);
    }
}
