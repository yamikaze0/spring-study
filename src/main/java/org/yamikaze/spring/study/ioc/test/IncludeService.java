package org.yamikaze.spring.study.ioc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author qinluo
 * @version 1.0.0
 * @date 2018/5/23 18:37
 */
@Service("includeService")
public class IncludeService {

    @Resource
    private ExcludeService abcsadas;

    public ExcludeService getExcludeService() {
        return abcsadas;
    }

    public void setExcludeService(ExcludeService excludeService) {
        this.abcsadas = excludeService;
    }

}
