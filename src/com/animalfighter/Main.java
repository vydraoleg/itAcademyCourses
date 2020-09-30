package com.animalfighter;

import com.animalfighter.api.service.IAnimalService;
import com.animalfighter.entities.Animal;
import com.animalfighter.entities.Cat;
import com.animalfighter.entities.Dog;
import com.animalfighter.service.AnimalService;
import com.animalfighter.utils.Fight;


public class Main {

    public static void main(String[] args) {

        IAnimalService animalService = new AnimalService();

        new Dog(animalService, "Жучка", 2, 15, Math.round(Math.random() * 20));
        new Dog(animalService, "Барбос", 3, 17, Math.round(Math.random() * 20));
        new Cat(animalService, "Мурзик", 5, 12, Math.round(Math.random() * 15));
        new Cat(animalService, "Васька", 4, 11, Math.round(Math.random() * 15));

        // print list of animalService
        for (Animal an : animalService.getAnimals()) {
            System.out.print(an.getNametype() + "'s name is  " + an.getName() + " strength is " + an.getStrength() + " says ");
            an.saySmth();
        }

        // Fight
        new Fight(animalService);
    }
}