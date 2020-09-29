package com.animalfighter.utils;

import com.animalfighter.entities.Animal;
import com.animalfighter.api.service.IFightAnimal;

import java.util.List;

public class Fight implements IFightAnimal {

    public Fight(List<Animal> animalFight){
        this.tournament(animalFight);
    }

    // Calculate Strength
    @Override
    public double calculateStrength(int type, int weight, double strength) {
        double result = 0;
        switch (type) {
            case 1:
                result = (weight + strength)/8;
                System.out.println("too weak hit");
                break;
            case 3:
                result = (weight + strength)/3;
                System.out.println("not direct hit");
                break;
            case 5:
                result = strength/5;
                System.out.println("direct hit");
                break;
            case 8:
                result = strength/2;
                System.out.println("strength hit");
                break;
            default:
                System.out.println("miss");
                break;
        }
        return result;
    }


    // function of fight
    @Override
    public void fightAnimal(Animal animal1, Animal animal2) {
        System.out.print(animal1.getName() + " beats ");
        animal2.setStrength(
                animal2.getStrength() -
                        this.calculateStrength((int) (Math.random() * 10),
                                animal1.getWeight(),
                                animal1.getStrength())
        );
    }
    // Main function
    public void tournament(List<Animal> animalFight){
        System.out.println("========== Fight tournament ==========");
        int sizeAnimals = animalFight.size();
        for(int i = 0 ; i < sizeAnimals -1 ; i++){
            Animal fighter1 = animalFight.get(i);
            for(int j = 1 ; j < sizeAnimals ; j++){
                if( i != j ){
                    Animal fighter2 = animalFight.get(j);
                    System.out.println(" ===== "+fighter1.getName()+ " vs " + fighter2.getName()+" ===== ");
                    while (fighter1.getStrength() > 0 && fighter2.getStrength() > 0) {
                        this.fightAnimal(fighter1, fighter2);
                        this.fightAnimal(fighter2, fighter1);
                    }
                    if (fighter1.getStrength() > fighter2.getStrength()) {
                        System.out.println(fighter1.getNametype() + " " + fighter1.getName() + " Great victory! with Strength="+fighter1.getStrength());
                    } else {
                        System.out.println(fighter2.getNametype() + " " + fighter2.getName() + " Great victory! with Strength="+fighter2.getStrength());
                    }

                }
            }
        }

    }
}
