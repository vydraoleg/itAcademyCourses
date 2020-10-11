package com.animalfighter.utils;

import com.animalfighter.entities.Animal;

import java.util.HashMap;
import java.util.Map;

public class FightThread implements Runnable {
    Animal fighter1;
    Animal fighter2;

    Map<String, Integer> winners ;

    public FightThread (Animal fighter1, Animal fighter2,  Map<String, Integer> winners){
        this.setFighter1(fighter1);
        this.setFighter2(fighter1);
        this.setWinners(winners);
    }
    public Animal getFighter1() {
        return fighter1;
    }

    public void setFighter1(Animal fighter1) {
        this.fighter1 = fighter1;
    }

    public Animal getFighter2() {
        return fighter2;
    }

    public void setFighter2(Animal fighter2) {
        this.fighter2 = fighter2;
    }

    public Map<String, Integer> getWinners() {
        return winners;
    }

    public void setWinners(Map<String, Integer> winners) {
        this.winners = winners;
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


    private void printFighters(Animal fighter1, Animal fighter2) {
        System.out.println(" ===== " +
                fighter1.getName() + " vs " + fighter2.getName() +
                " ===== ");
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
    @Override
    public void run() {
        printFighters(fighter1, fighter2);
        double strength1 = fighter1.getStrength() / 2; // 50%
        double strength2 = fighter2.getStrength() / 2; // 50%
        int flagSaveFighter1 = 0;
        int flagSaveFighter2 = 0;

        while (fighter1.getStrength() > 0 && fighter2.getStrength() > 0) {
            this.fightAnimal(fighter1, fighter2);
            this.fightAnimal(fighter2, fighter1);
// Serialize
            if (flagSaveFighter1 == 0 && strength1 > fighter1.getStrength() && fighter1.getStrength() > 0) {
                flagSaveFighter1 = 1;
                new SerializationUtil().serialize(fighter1, "..\\animal1.info");
            }
            if (flagSaveFighter2 == 0 && strength2 > fighter2.getStrength() && fighter2.getStrength() > 0) {
                flagSaveFighter2 = 1;
                new SerializationUtil().serialize(fighter2, "..\\animal2.info");
            }
//Deserialize
            if (fighter1.getStrength() <= 0 && flagSaveFighter1 == 1 && Math.random() > 0.5) {
                flagSaveFighter1 = 2;
                fighter1 = new SerializationUtil().deserialize("..\\animal1.info");
            }
            if (fighter2.getStrength() <= 0 && flagSaveFighter2 == 1 && Math.random() > 0.5) {
                flagSaveFighter2 = 2;
                fighter2 = new SerializationUtil().deserialize("..\\animal2.info");
            }
        }
// Print winner in current fight
        this.printWinner((fighter1.getStrength() > fighter2.getStrength()) ?
                fighter1 : fighter2);

    }
}
