package org.yamikaze.spring.study.cache.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinluo
 * @version 1.0.0
 * @date 2018/5/14 13:02
 */
@Service("cacheServiceImpl")
public class CacheServiceImpl {

    private static Logger logger = LoggerFactory.getLogger(CacheServiceImpl.class);

    private static final int MAX_SIZE = 100000;

    @Cacheable(value = "test_cache", key = "#root.methodName")
    public List<String> getAllData() {
        logger.info("cache is evict, current time is {}", System.currentTimeMillis());
        List<String> list = new ArrayList<>(16);

        for(int i = 0; i < MAX_SIZE; i ++) {
            list.add("" + i);
        }

        return list;

    }


}
