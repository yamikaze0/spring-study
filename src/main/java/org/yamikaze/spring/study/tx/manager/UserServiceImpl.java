package org.yamikaze.spring.study.tx.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.yamikaze.dao.IUserDao;
import org.yamikaze.model.User;
import org.yamikaze.spring.study.tx.UserService;

/**
 * 编程式事务
 * @author qinluo
 * @date 2017/12/21
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private DataSourceTransactionManager transactionManager;

    @Override
    public boolean addUser(User user) {
        DefaultTransactionDefinition dtd = new DefaultTransactionDefinition();
        //设置事务隔离级别
        dtd.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
        dtd.setName("myTransaction");
        dtd.setReadOnly(false);
        /*设置超时时间，单位：秒*/
        dtd.setTimeout(3);
        /*获取到事务状态*/
        TransactionStatus status = transactionManager.getTransaction(dtd);
        try {
            boolean flag = userDao.save(user) == 1;
            if(flag) {
                throw new RuntimeException();
            }
            transactionManager.commit(status);
        } catch (Exception e) {
            //回滚 & 异常处理
            transactionManager.rollback(status);
            throw e;
        } finally {
            /*其他操作*/
        }
        return false;
    }
}
