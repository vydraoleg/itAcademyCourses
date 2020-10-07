package com.entity;

import java.util.List;

public class Adult extends Person {
    private transient List<Child> children;
    private int salary;

    public Adult(List<Child> children) {
        this.children = children;
    }

    public Adult(String name, int age, List<Child> children) {
        super(name, age);
        this.children = children;
    }
    public Adult(String name, int age) {
        super(name, age);
    }
}
