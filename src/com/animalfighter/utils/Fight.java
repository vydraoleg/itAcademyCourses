package com.animalfighter.utils;

import com.animalfighter.entities.Animal;
import com.animalfighter.api.service.IFightAnimal;

public class Fight implements IFightAnimal {

    // Calculate Strength
    @Override
    public int calculateStrength(int type, int weight, int strength) {
        int result = 0;
        switch (type) {
            case 1:
                result = 1;//(int)(weight + strength)/10;
                System.out.println("too weak hit");
                break;
            case 3:
                result = 3;//(int)(weight + strength)/20;
                System.out.println("not direct hit");
                break;
            case 5:
                result = 5;//(int) strength/5;
                System.out.println("direct hit");
                break;
            case 8:
                result = 7;//(int) strength/2;
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

}
