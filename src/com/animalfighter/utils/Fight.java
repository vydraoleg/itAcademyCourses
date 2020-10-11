package com.animalfighter.utils;

import com.animalfighter.api.service.IAnimalService;
import com.animalfighter.entities.Animal;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Map.Entry;

public class Fight {

    Map<String, Integer> winners = new HashMap<>();
    static FightThread fightThread;

    public Fight(IAnimalService animalService) {
        this.tournament(animalService);
    }


    private void printWinners() {
        String myList = " ===== List of winners: ===== \n";

        List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(winners.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<String, Integer> x : list) {
            myList = myList.concat(String.format("Name of winner: %s  Wins: %d \n", x.getKey(), x.getValue()));
        }

        System.out.print(myList);
        new WorkWithFile().saveToFile(myList, "..\\winners.txt");
    }


    // Main function
    private void tournament(IAnimalService animalService) {
        List<Animal> animalFight = animalService.getAnimals();
        System.out.println(" ========== Fight tournament ==========");

        Animal fighter1;
        Animal fighter2;
        int sizeAnimals = animalFight.size();
        for (; ; ) {
            fighter1 = null;
            fighter2 = null;
            // Looking for first fighter
            for (int i = 0; i < sizeAnimals - 1; i++) {
                if (animalFight.get(i).getStrength() > 0) {
                    fighter1 = animalFight.get(i);
                }
            }
            // Looking for second fighter
            for (int j = 0; j < sizeAnimals; j++) {
                if (animalFight.get(j).getStrength() > 0
                        && !animalFight.get(j).equals(fighter1))
                    fighter2 = animalFight.get(j);
            }

            if (fighter1 == null || fighter2 == null) break;

            fightThread = new FightThread(fighter1, fighter2, winners);
//            Thread newThread1 = new Thread(fightThread);
//            newThread1.start();

            fightThread.run();
            fighter1 = fightThread.getFighter1();
            fighter2 = fightThread.getFighter2();
            winners = fightThread.getWinners();

// Save resulting Strength for Second fighter
            animalService.updateAnimalStrength(fighter2.getName(),(int) fighter2.getStrength());
// Save resulting Strength for First fighter
            animalService.updateAnimalStrength(fighter1.getName(),(int) fighter1.getStrength());


        }
        printWinners();
    }

}
