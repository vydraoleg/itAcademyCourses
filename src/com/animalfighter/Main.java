package com.animalfighter;

import com.animalfighter.api.service.IAnimalService;
import com.animalfighter.entities.Animal;
import com.animalfighter.entities.Cat;
import com.animalfighter.entities.Dog;
import com.animalfighter.service.AnimalService;
import com.animalfighter.utils.Fight;
import com.animalfighter.utils.ReadFromFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {

        IAnimalService animalService = new AnimalService();

        // Read Animal Fighter from file and add to animalService
        animalService.getAnimals()
                .addAll(new ReadFromFile().AnimalFromFile());


        if(!animalService.getAnimals().isEmpty()){

            // print list of animalService
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