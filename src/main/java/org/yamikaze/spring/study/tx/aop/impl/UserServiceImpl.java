package org.yamikaze.spring.study.tx.aop.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yamikaze.dao.IUserDao;
import org.yamikaze.model.User;
import org.yamikaze.spring.study.tx.UserService;

/**
 * @author yamikaze
 * @date 2017/12/21
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private IUserDao userDao;

    @Override
    public boolean addUser(User user) {
        boolean flag = userDao.save(user) == 1;
        if(flag) {
            throw new RuntimeException();
        }
        return true;
    }
}
