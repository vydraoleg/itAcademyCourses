package com.animalfighter.utils;

import com.animalfighter.api.service.IAnimalService;
import com.animalfighter.entities.Animal;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Map.Entry;

public class Fight {

    Map<String, Integer> winners = new HashMap<>();
    Map<Animal, Thread> threadAnimal = new HashMap<>();
    Map<Thread, FightThread> listThread = new HashMap<>();

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


    // Main tournament function
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
                if (animalFight.get(i).getStrength() > 0 &&
                        !threadAnimal.containsKey(animalFight.get(i))) {
                    fighter1 = animalFight.get(i);
                }
            }
            // Looking for second fighter
            for (int j = 1; j < sizeAnimals; j++) {
                if (animalFight.get(j).getStrength() > 0 &&
                        !animalFight.get(j).equals(fighter1) &&
                        !threadAnimal.containsKey(animalFight.get(j))) {
                    fighter2 = animalFight.get(j);
                }
            }
            // if not exists fighter with strength > 0 and All thread is not alive exit from forever cycle
            if ((fighter1 == null || fighter2 == null) && threadAnimal.isEmpty()) break;

            //Remove all Threads is not Alive
            Iterator<Map.Entry<Animal, Thread>> thread = threadAnimal.entrySet().iterator();
            while (thread.hasNext()) {
                Map.Entry<Animal, Thread> entry = thread.next();
                if (!entry.getValue().isAlive()) {
                    // Save resulting Strength for Second fighter
                    animalService.updateAnimalStrength(entry.getKey().getName(), (int) entry.getKey().getStrength());
                    if (listThread.containsKey(entry.getValue())) {
                        winners = listThread.get(entry.getValue()).getWinners();
                        listThread.remove(entry.getValue());
                    }
// Remove current Animal from list of thread
//                    threadAnimal.remove(entry.getKey());
                    thread.remove();
                }
            }
// Starting thread of Fight
            if (fighter1 != null && fighter2 != null) {
                FightThread fightThread = new FightThread(fighter1, fighter2, winners);
                Thread newThread1 = new Thread(fightThread);
                threadAnimal.put(fighter1, newThread1);
                threadAnimal.put(fighter2, newThread1);
                listThread.put(newThread1, fightThread);
                newThread1.start();
//                fightThread.run();
            }
        }
        printWinners();
    }

}
