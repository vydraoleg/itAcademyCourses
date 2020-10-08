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
        String myList = " ===== List of winners: ===== \n";
//        winners.entrySet().stream()
//                .sorted(Map.Entry.comparingByValue())
//                .forEach(x -> System.out.print(String.format("Name of winner: %s  Wins: %d \n", x.getKey(), x.getValue())));
//                .forEach(x-> myList.concat(String.format("Name of winner: %s  Wins: %d \n", x.getKey(), x.getValue())));
        for (Map.Entry<String, Integer> x : winners.entrySet()) {
            myList = myList.concat(String.format("Name of winner: %s  Wins: %d \n", x.getKey(), x.getValue()));
        }
        System.out.print(myList);
        new WorkWithFile().saveToFile(myList);
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
                double strength1 = fighter1.getStrength() / 2; // 50%
                double strength2 = fighter2.getStrength() / 2; // 50%
                int flagSaveFighter1 = 0;
                int flagSaveFighter2 = 0;

                while (fighter1.getStrength() > 0 && fighter2.getStrength() > 0) {
                    this.fightAnimal(fighter1, fighter2);
                    this.fightAnimal(fighter2, fighter1);
// Serialize
                    if (flagSaveFighter1==0 && strength1 > fighter1.getStrength() && fighter1.getStrength() > 0) {
                        flagSaveFighter1 = 1;
                        new SerializationUtil().serialize(fighter1, "..\\animal1.info");
                    }
                    if (flagSaveFighter2==0 && strength2 > fighter2.getStrength() && fighter2.getStrength() >0) {
                        flagSaveFighter2 = 1;
                        new SerializationUtil().serialize(fighter2, "..\\animal2.info");
                    }
//Deserialize
                    if (fighter1.getStrength() <= 0 && flagSaveFighter1==1 && Math.random() > 0.5) {
                        flagSaveFighter1 = 2;
                        fighter1 = new SerializationUtil().deserialize("..\\animal1.info");
                    }
                    if (fighter2.getStrength() <= 0 && flagSaveFighter2==1 && Math.random() > 0.5) {
                        flagSaveFighter2 = 2;
                        fighter2 = new SerializationUtil().deserialize("..\\animal2.info");
                    }
                }
                this.printWinner((fighter1.getStrength() > fighter2.getStrength()) ?
                        fighter1 : fighter2);

// Save resulting Strength for Second fighter
                animalService.updateAnimalStrength(fighter2.getName(),
                        (int) fighter2.getStrength());
            }
// Save resulting Strength for First fighter
            animalService.updateAnimalStrength(fighter1.getName(),
                    (int) fighter1.getStrength());
        }
        printWinners();
    }
}
