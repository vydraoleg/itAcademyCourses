package com.itacademy.firstgit.animals;

public class Pig {
    String name;
    int Age;

    public Pig(String name) {
        this.name = name;
    }
    public Pig(String name, int age) {
        this.name = name;
        Age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }


}
