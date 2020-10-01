package com.animalfighter.entities;

public class Cat extends Animal {

    @Override
    public void saySmth() {
        System.out.println("Meow");
    }

    public Cat() {
        setNametype("Cat");
    }

    public Cat(String name, int age, int weight, double strenght) {
        this();
        this.setName(name);
        this.setAge(age);
        this.setWeight(weight);
        this.setStrength(strenght);
    }

    public Cat(String name, int age) {
        this(name, age, 1, 1);
    }

}