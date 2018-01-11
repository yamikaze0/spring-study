package org.yamikaze.disconf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author yamikaze
 * @date 2018/1/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:disconf.xml")
public class LocalFileTest {

    @Autowired
    private GlobalConfig config;

    @Test
    public void testLocalFile() {
        System.out.println(config);
    }

    /**
     * 睡眠60s，留下时间与Zookeeper通信并下载新文件
     * 替换掉旧的配置 如果是一个配置文件发生了改变，配置文件对应的所有配置项都会被更新
     * 1515664191648
     * 1515664195167
     */
    @Test
    public void testCallBack() throws Exception{
        System.out.println(config);
        TimeUnit.SECONDS.sleep(60);
    }
}
