package com.gmcx.wpx.model;


/**
 * Created by wpx on 2017/8/1.
 */
public class User{

    protected int user_Id;
    protected String user_Name;
    protected int user_Age;

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public int getUser_Age() {
        return user_Age;
    }

    public void setUser_Age(int user_Age) {
        this.user_Age = user_Age;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_Id=" + user_Id +
                ", user_Name='" + user_Name + '\'' +
                ", user_Age=" + user_Age +
                '}';
    }
}
