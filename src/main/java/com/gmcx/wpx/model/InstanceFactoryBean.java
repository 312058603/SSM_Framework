package com.gmcx.wpx.model;

/**
 * Created by wpx on 2017/7/6.
 */
public class InstanceFactoryBean {

    private static Person person3 = new Person();

    private InstanceFactoryBean() {}

    public Person createPerson() {
        return person3;
    }

}
