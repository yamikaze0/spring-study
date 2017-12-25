package org.yamikaze.spring.study.lazy;

/**
 * @author yamikaze
 * @date 2017/12/18
 */
public class HokaGe {

    private JioNin jioNin;

    public HokaGe() {
        System.out.println("我成为了火影!");
    }

    public JioNin getJioNin() {
        return jioNin;
    }

    public void setJioNin(JioNin jioNin) {
        this.jioNin = jioNin;
    }
}
