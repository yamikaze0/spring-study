package org.yamikaze.spring.study.bean.merge;

/**
 * @author qinluo
 * @version 1.0.0
 * @since 2019/1/28 17:40
 */
public class MergeApiImpl implements MergeApi {

    @Override
    public void merge() {
        System.out.println("hello merge!");
    }
}
