package com.animalfighter.dao;

import com.animalfighter.api.dao.IAnimalDao;
import com.animalfighter.api.exception.AnimalNotFoundException;
import com.animalfighter.entities.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnimalDao implements IAnimalDao {

    private List<Animal> animals = new ArrayList<>();

    @Override
    public List<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println(animal.getNametype() + " was added, " + animal.toString());
    }

    public Animal getByName(String name) throws AnimalNotFoundException {
        Optional<Animal> optionalAnimal =
                animals.stream()
                        .filter(x -> x.getName().equals(name))
                        .findFirst();
        Animal animal = optionalAnimal.orElseThrow(() -> new AnimalNotFoundException());

        return animal;
    }

    public void updateAnimalStrength(String name, int strength) throws AnimalNotFoundException  {
        Animal animal = this.getByName(name);
        animal.setStrength(strength);
        System.out.println(animal.getNametype()+" was updated, " + animal.toString());
    }

    public void setAnimal(List<Animal> animals) {
        this.animals = animals;
    }

}
