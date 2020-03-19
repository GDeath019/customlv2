package com.example.ctlvbase;

public class data {
    String name;
    int picture;

    public String getName() {
        return name;
    }

    public int getPicture() {
        return picture;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public data(String name, int picture) {
        this.name = name;
        this.picture = picture;
    }
}
