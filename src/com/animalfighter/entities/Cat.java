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
        setName(name);
        setAge(age);
        setWeight(weight);
        setStrength(strenght);
        animalService.addAnimal(this);
    }

    public Cat(IAnimalService animalService, String name, int age) {
        this();
        setName(name);
        setAge(age);
        setWeight(1);
        setStrength(1);
        animalService.addAnimal(this);
    }

}