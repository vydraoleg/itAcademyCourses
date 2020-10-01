package com.animalfighter;

import com.animalfighter.api.service.IAnimalService;
import com.animalfighter.entities.Animal;
import com.animalfighter.entities.Cat;
import com.animalfighter.entities.Dog;
import com.animalfighter.service.AnimalService;
import com.animalfighter.utils.Fight;

import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {

        IAnimalService animalService = new AnimalService();

        animalService.getAnimals()
                .addAll(Stream.of(
                        new Dog("Жучка", 2, 15, Math.round(Math.random() * 20)),
                        new Dog("Барбос", 3, 17, Math.round(Math.random() * 20)),
                        new Cat("Мурзик", 5, 12, Math.round(Math.random() * 15)),
                        new Cat("Васька", 4, 11, Math.round(Math.random() * 15)))
                        .collect(Collectors.toList()));

        // print list of animalService
        animalService.getAnimals().stream()
                .peek(an -> System.out.print(an.getNametype() + "'s name is  " + an.getName() + " strength is " + an.getStrength() + " says "))
                .forEach(Animal::saySmth);
        // Fight
        new Fight(animalService);
    }
}