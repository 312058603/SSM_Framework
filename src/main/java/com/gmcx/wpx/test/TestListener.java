package com.gmcx.wpx.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by wpx on 2017/7/5.
 */
public class TestListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event){
        System.out.println("TestListener contextInitialized");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("TestListener contextDestroyed");
    }

}
