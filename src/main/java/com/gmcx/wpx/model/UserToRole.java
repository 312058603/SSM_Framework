package com.gmcx.wpx.model;

/**
 * Created by wpx on 2017/8/7.
 */
public class UserToRole extends User{

    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserToRole{" +
                "user_Id=" + user_Id +
                ", role=" + role +
                ", user_Name='" + user_Name + '\'' +
                ", user_Age=" + user_Age +
                '}';
    }

}
