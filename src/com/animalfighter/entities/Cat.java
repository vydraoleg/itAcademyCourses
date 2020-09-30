package com.animalfighter.entities;

import com.animalfighter.api.service.IAnimalService;

public class Cat extends Animal {

    @Override
    public void saySmth() {
        System.out.println("Meow");
    }

    public Cat() {
        setNametype("Cat");
    }

    public Cat(IAnimalService animalService, String name, int age, int weight, double strenght) {
        this();
        this.setName(name);
        this.setAge(age);
        this.setWeight(weight);
        this.setStrength(strenght);
        animalService.addAnimal(this);
    }

    public Cat(IAnimalService animalService, String name, int age) {
        this(animalService, name,age,1,1);
    }

}