package com.xiaofei.entity;

import java.io.Serializable;

/**
 * Created by yangrao on 2020/3/25.
 */
public class Mobile implements Serializable{
    private int id;
    private String os;
    private String mName;
    private String operSystem;
    private int userId;
    private int status;

    public int getId() {
        return id;
    }

    public String getOs() {
        return os;
    }

    public String getmName() {
        return mName;
    }

    public String getOperSystem() {
        return operSystem;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setOperSystem(String operSystem) {
        this.operSystem = operSystem;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {

        return userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "id=" + id +
                ", os='" + os + '\'' +
                ", mName='" + mName + '\'' +
                ", operSystem='" + operSystem + '\'' +
                ", userId=" + userId +
                '}';
    }
}
