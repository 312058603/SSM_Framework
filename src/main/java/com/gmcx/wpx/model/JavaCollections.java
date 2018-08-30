package com.gmcx.wpx.model;

import java.util.*;

/**
 * Created by wpx on 2017/7/7.
 */
public class JavaCollections {

    private int id;
    private Person[] array;
    private List<Person> list;
    private Set<Person> set;
    private Map<Integer,Person> map;
    private Properties properties;

    public JavaCollections() {
    }

    public JavaCollections(int id, Person[] array, List<Person> list, Set<Person> set, Map<Integer, Person> map, Properties properties) {
        this.id = id;
        this.array = array;
        this.list = list;
        this.set = set;
        this.map = map;
        this.properties = properties;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person[] getArray() {
        return array;
    }

    public void setArray(Person[] array) {
        this.array = array;
    }

    public List<Person> getList() {
        return list;
    }

    public void setList(List<Person> list) {
        this.list = list;
    }

    public Set<Person> getSet() {
        return set;
    }

    public void setSet(Set<Person> set) {
        this.set = set;
    }

    public Map<Integer, Person> getMap() {
        return map;
    }

    public void setMap(Map<Integer, Person> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "JavaCollections{" +
                "id=" + id +
                ", array=" + Arrays.toString(array) +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }
}
