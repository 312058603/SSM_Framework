package com.gmcx.wpx.model;

import java.util.Properties;

/**
 * Created by wpx on 2017/7/7.
 */
public class MergeProperties {

    private Properties properties;

    public MergeProperties() {
    }

    public MergeProperties(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "MergeProperties{" +
                "properties=" + properties +
                '}';
    }
}
