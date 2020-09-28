package com.animalfighter.entities;

public class Dog extends Animal {

    public Dog() {
        this.nametype = "Dog";
    }

    public Dog(String name, Integer age, int weight, int strenght) {
        this();
        this.setName(name);
        this.setAge(age);
        this.setWeight(weight);
        this.setStrength(strenght);
    }

    @Override
    public void saySmth() {
        System.out.println("Bark!");
    }

}
