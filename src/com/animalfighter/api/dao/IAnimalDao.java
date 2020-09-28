package com.animalfighter.api.dao;

import com.animalfighter.api.exception.AnimalNotFoundException;
import com.animalfighter.entities.Animal;

import java.util.List;

public interface IAnimalDao {

    List<Animal> getAnimals();

    void addAnimal(Animal animal);

    Animal getByName(String name) throws AnimalNotFoundException;

    void updateAnimalStrength(String name, int strength) throws AnimalNotFoundException;
}
