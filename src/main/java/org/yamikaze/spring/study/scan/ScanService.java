package org.yamikaze.spring.study.scan;

import org.springframework.stereotype.Service;

/**
 * @author yamikaze
 * @version 1.0.0
 * @date 2018/3/20 12:51
 */
@Service("scanService")
public class ScanService {

    public ScanService() {
        System.out.println("init scan service...");
    }
}
