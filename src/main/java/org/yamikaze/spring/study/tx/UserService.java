package org.yamikaze.spring.study.tx;

import org.yamikaze.model.User;

/**
 * @author yamikaze
 * @date 2017/12/21
 */
public interface UserService {

    /**
     * 添加用户, 假设这个方法有多条sql插入修改
     * @param user
     * @return
     */
    boolean addUser(User user);
}
