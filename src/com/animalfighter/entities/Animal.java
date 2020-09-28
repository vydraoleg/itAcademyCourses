package com.animalfighter.entities;

public class Animal {

    private String name;
    protected int age;
    protected int weight;
    protected int strength;
    protected String nametype;   // Name of type

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getNametype() {
        return nametype;
    }

    public void setNametype(String nameType) {
        this.nametype = nameType;
    }

    public void saySmth() {
        System.out.println("say smth");
    }
}
