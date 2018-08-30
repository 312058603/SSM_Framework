package com.gmcx.wpx.model;

/**
 * Created by wpx on 2017/7/6.
 */
public class StaticFactoryBean {

    private static StaticFactoryBean staticFactoryBean = new StaticFactoryBean();

    private StaticFactoryBean() {}

    public static StaticFactoryBean createInstance() {
        return staticFactoryBean;
    }

}
