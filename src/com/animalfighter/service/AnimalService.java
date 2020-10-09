package com.animalfighter.service;

import com.animalfighter.api.dao.IAnimalDao;
import com.animalfighter.api.exception.AnimalNotFoundException;
import com.animalfighter.api.service.IAnimalService;
import com.animalfighter.dao.AnimalDao;
import com.animalfighter.entities.Animal;
import com.animalfighter.entities.Cat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AnimalService implements IAnimalService {
    IAnimalDao animalDao = new AnimalDao();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


    public List<Animal> getAnimals() {
        return animalDao.getAnimals();
    }

    @Override
    public void addAnimal(Animal animal) {
        animalDao.addAnimal(animal);
    }

    @Override
    public Animal getByName(String name) {
        try {
            return animalDao.getByName(name);
        } catch (AnimalNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println(LocalDateTime.now().format(format) + " Exception caught, AnimalNotFoundException!");
            return null;
        }
    }

    @Override
    public void updateAnimalStrength(String name, int strength) {
        try {
            animalDao.updateAnimalStrength(name, strength);
        } catch (AnimalNotFoundException e) {
            Animal an = new Cat();
            an.setName(name);
            an.setStrength(strength);
            this.addAnimal(an);
        }
    }

}
