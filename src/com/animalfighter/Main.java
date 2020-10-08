package com.animalfighter;

import com.animalfighter.api.service.IAnimalService;
import com.animalfighter.entities.Animal;
import com.animalfighter.service.AnimalService;
import com.animalfighter.utils.Fight;
import com.animalfighter.utils.WorkWithFile;


public class Main {

    public static void main(String[] args) {

        IAnimalService animalService = new AnimalService();

        // Read Animal Fighter from file and add to animalService
        animalService.getAnimals()
                .addAll(new WorkWithFile().animalFromFile());

        if (!animalService.getAnimals().isEmpty()) {

            // print list of animals from animalService
            animalService.getAnimals().stream()
                    .peek(an -> System.out.print(an.getNametype() + "'s name is  " + an.getName() + " strength is " + an.getStrength() + " says "))
                    .forEach(Animal::saySmth);

            // Fight
            new Fight(animalService);
        } else {
            System.out.println("There is not list of fighter!");
        }
    }
}