package org.yamikaze.spring.study.tx.annotation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    /**
     * 1、当有多个事务管理器时要指定使用哪个事务管理器，否则发生异常时不会进行数据回滚
     * 2、@Transactional注解默认是RuntimeException会进行回滚，而Exception不会进行
     *    所以要加上rollbackFor以方便在发生Exception时进行数据回滚
     * @param user
     * @return
     */
    @Transactional(rollbackFor = Exception.class, value = "tx")
    @Override
    public boolean addUser(User user) {
        boolean flag = userDao.save(user) == 1;
        if(flag) {
            System.out.println("before throw exception ... ");
            throw new RuntimeException();
        }
        return false;
    }
}
