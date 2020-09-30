package com.animalfighter.service;

import com.animalfighter.api.dao.IAnimalDao;
import com.animalfighter.api.exception.AnimalNotFoundException;
import com.animalfighter.api.service.IAnimalService;
import com.animalfighter.dao.AnimalDao;
import com.animalfighter.entities.Animal;
import com.animalfighter.utils.CriticalHitCounter;

import java.io.IOException;
import java.util.List;

public class AnimalService implements IAnimalService {
    IAnimalDao animalDao = new AnimalDao();

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
        } catch (Exception e) {   /// нужно ловить конкретную ошибку
            // e.printStackTrace(); // Выкинуть в логи всю цепочку не пишут
            System.out.println("Exception caught!");
            Animal animalTemp = new Animal();
            this.animalDao.addAnimal(animalTemp);
            return animalTemp;
        } finally {
            System.out.println("...");
        }
    }

    @Override
    public void updateAnimalStrength(String name, int strength) {
        try {
            animalDao.updateAnimalStrength(name, strength);
        } catch (AnimalNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void doSmth() {
        try {
            CriticalHitCounter.doSmth();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
