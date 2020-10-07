package com.entity;

import java.io.Serializable;

public class Child extends Person{

    private String toy;

    public Child(String name, int age) {
        super(name, age);
    }
    public Child(String name, int age, String toy) {
        super(name, age);
        this.toy = toy;
    }
}
