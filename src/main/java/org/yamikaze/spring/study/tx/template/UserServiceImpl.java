package org.yamikaze.spring.study.tx.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.yamikaze.dao.IUserDao;
import org.yamikaze.model.User;
import org.yamikaze.spring.study.tx.UserService;

/**
 * 使用事务模板
 * @author yamikaze
 * @date 2017/12/21
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public boolean addUser(User user) {
        /*可以使用java8的lamda表达式，但是要注意Spring的版本必须能够支持java 8*/
        transactionTemplate.execute(new TransactionCallback<Object>() {

            @Override
            public Object doInTransaction(TransactionStatus status) {
                boolean flag = userDao.save(user) == 1;
                if(flag) {
                    throw new RuntimeException();
                }
                return true;
            }
        });
        
        return false;
    }
}
