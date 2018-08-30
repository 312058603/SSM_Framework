package com.gmcx.wpx.model;

/**
 * Created by wpx on 2017/8/7.
 */
public class Role{

    private int role_Id;
    private int user_Id;
    private String role_Name;

    public int getRole_Id() {
        return role_Id;
    }

    public void setRole_Id(int role_Id) {
        this.role_Id = role_Id;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public String getRole_Name() {
        return role_Name;
    }

    public void setRole_Name(String role_Name) {
        this.role_Name = role_Name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_Id=" + role_Id +
                ", user_Id=" + user_Id +
                ", role_Name='" + role_Name + '\'' +
                '}';
    }
}
