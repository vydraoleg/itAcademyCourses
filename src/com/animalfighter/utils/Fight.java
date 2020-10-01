package com.animalfighter.utils;

import com.animalfighter.api.service.IAnimalService;
import com.animalfighter.entities.Animal;

import java.util.*;

public class Fight {

    Map<String, Integer> winners = new HashMap<>();

    public Fight(IAnimalService animalService) {
        this.tournament(animalService);
    }

    // Calculate Strength
    private double calculateStrength(int type, int weight, double strength) {
        double result = 0;
        switch (type) {
            case 1:
                result = (weight + strength) / 8;
                System.out.println("too weak hit");
                break;
            case 3:
                result = (weight + strength) / 3;
                System.out.println("not direct hit");
                break;
            case 5:
                result = strength / 5;
                System.out.println("direct hit");
                break;
            case 8:
                result = strength / 2;
                System.out.println("strength hit");
                break;
            default:
                System.out.println("miss");
                break;
        }
        return Math.round(result);
    }


    // function of fight
    private void fightAnimal(Animal animal1, Animal animal2) {
        System.out.print(animal1.getName() + " beats ");
        animal2.setStrength(
                animal2.getStrength() -
                        this.calculateStrength((int) (Math.random() * 10),
                                animal1.getWeight(),
                                animal1.getStrength())
        );
    }

    private void printWinner(Animal fighter) {
        int wins = 1;
        String nameFighter = fighter.getName();
        System.out.println(fighter.getNametype() +
                " " + nameFighter +
                " Great victory! with Strength=" +
                fighter.getStrength());
        if (winners.containsKey(nameFighter))
            wins = winners.get(nameFighter) + 1;
        winners.put(nameFighter, wins);

    }

    private void printWinners() {
        System.out.println(" ===== List of winners: ===== ");
        winners.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(x -> System.out.printf("Name of winner: %s  Wins: %d \n", x.getKey(), x.getValue()));
    }

    private void printFighters(Animal fighter1, Animal fighter2) {
        System.out.println(" ===== " +
                fighter1.getName() + " vs " + fighter2.getName() +
                " ===== ");
    }

    // Main function
    private void tournament(IAnimalService animalService) {
        List<Animal> animalFight = animalService.getAnimals();
        System.out.println(" ========== Fight tournament ==========");
        int sizeAnimals = animalFight.size();
        for (int i = 0; i < sizeAnimals - 1; i++) {
            Animal fighter1 = animalFight.get(i);
            for (int j = i + 1; j < sizeAnimals; j++) {
                Animal fighter2 = animalFight.get(j);

                printFighters(fighter1, fighter2);

                while (fighter1.getStrength() > 0 && fighter2.getStrength() > 0) {
                    this.fightAnimal(fighter1, fighter2);
                    this.fightAnimal(fighter2, fighter1);
                }
                this.printWinner((fighter1.getStrength() > fighter2.getStrength()) ?
                        fighter1 : fighter2);

// Save Strength for Second fighter
                animalService.updateAnimalStrength(fighter2.getName(),
                        (int) fighter2.getStrength());
            }
// Save Strength for First fighter
            animalService.updateAnimalStrength(fighter1.getName(),
                    (int) fighter1.getStrength());
        }
        printWinners();
    }
}
