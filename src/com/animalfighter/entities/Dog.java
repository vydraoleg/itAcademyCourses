package com.animalfighter.entities;

import com.animalfighter.api.service.IAnimalService;

public class Dog extends Animal {

    public Dog() {
        setNametype("Dog");
    }

    public Dog(IAnimalService animalService, String name, int age, int weight, double strenght) {
        this();
        setName(name);
        setAge(age);
        setWeight(weight);
        setStrength(strenght);
        animalService.addAnimal(this);
    }

    @Override
    public void saySmth() {
        System.out.println("Bark!");
    }

}
