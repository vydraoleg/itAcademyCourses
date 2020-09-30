package com.animalfighter.entities;

import com.animalfighter.api.service.IAnimalService;

public class Dog extends Animal {

    public Dog() {
        setNametype("Dog");
    }

    public Dog(IAnimalService animalService, String name, int age, int weight, double strenght) {
        this();
        this.setName(name);
        this.setAge(age);
        this.setWeight(weight);
        this.setStrength(strenght);
        animalService.addAnimal(this);
    }

    @Override
    public void saySmth() {
        System.out.println("Bark!");
    }

}
