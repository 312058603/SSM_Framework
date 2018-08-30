package com.gmcx.wpx.model;

/**
 * Created by wpx on 2017/7/6.
 */
public class Student {

    private Person person;

    public Student() {
    }

    public Student(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
