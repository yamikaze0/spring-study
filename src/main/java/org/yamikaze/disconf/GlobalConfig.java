package org.yamikaze.disconf;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import org.springframework.stereotype.Component;

/**
 * @author yamikaze
 * @date 2018/1/11
 */
@DisconfFile(filename = "global.properties")
@Component
public class GlobalConfig {

    /**
     * 当前环境
     */
    private String env;

    /**
     * 应用启动时间
     */
    private String startTime;

    /**
     * 当前应用的版本
     */
    private String version;

    /**
     * 作者
     */
    private String author;

    /**
     * 应用名称
     */
    private String appName;

    @DisconfFileItem(name = "global.env", associateField = "env")
    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        startTime = String.valueOf(System.currentTimeMillis());
        this.env = env;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @DisconfFileItem(name = "global.version", associateField = "version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @DisconfFileItem(name = "global.author", associateField = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @DisconfFileItem(name = "global.appName", associateField = "appName")
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Override
    public String toString() {
        return "the application name is " + appName +
                " and the version is " + version +
                " and the start time is " + startTime +
                " and the env is " + env +
                " and last author is " + author;
    }
}
