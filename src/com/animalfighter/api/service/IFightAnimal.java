package com.animalfighter.api.service;

import com.animalfighter.entities.Animal;

public interface IFightAnimal {
    public int calculateStrength(int type, int weight, int strength);

    public void fightAnimal(Animal animal1, Animal animal2);
}
