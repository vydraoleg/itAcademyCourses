package com.animalfighter.api.service;

import com.animalfighter.api.exception.AnimalNotFoundException;
import com.animalfighter.entities.Animal;

import java.util.List;

public interface IAnimalService {

    List<Animal> getAnimals();

    void addAnimal(Animal animal);

    Animal getByName(String name);

    void updateAnimalStrength(String name, int strength) throws AnimalNotFoundException;

}
