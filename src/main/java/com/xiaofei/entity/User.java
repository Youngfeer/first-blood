package com.xiaofei.entity;

import java.io.Serializable;

/**
 * Created by yangrao on 2020/3/14.
 */
public class User implements Serializable{

    private String username;

    private String password;

    private String shotName;

    public String getName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getShotName() {
        return shotName;
    }

    public void setName(String name) {
        this.username = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setShotName(String shotName) {
        this.shotName = shotName;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + username + '\'' +
                ", password='" + password + '\'' +
                ", shotName='" + shotName + '\'' +
                '}';
    }
}
