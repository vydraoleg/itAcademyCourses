package com.animalfighter.api.service;

import com.animalfighter.entities.Animal;

public interface IFightAnimal {
    public double calculateStrength(int type, int weight, double strength);

    public void fightAnimal(Animal animal1, Animal animal2);
}
