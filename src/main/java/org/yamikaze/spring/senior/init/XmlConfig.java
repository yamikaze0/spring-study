package org.yamikaze.spring.senior.init;

/**
 * @author qinluo
 * @version 1.0.0
 * @since 2019/2/17 14:12
 */
public class XmlConfig {

    private String userId;

    private InitService initService;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public InitService getInitService() {
        return initService;
    }

    public void setInitService(InitService initService) {
        this.initService = initService;
    }
}
