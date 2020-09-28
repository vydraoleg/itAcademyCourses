package com.animalfighter;

import com.animalfighter.api.service.IAnimalService;
import com.animalfighter.entities.Animal;
import com.animalfighter.entities.Cat;
import com.animalfighter.entities.Dog;
import com.animalfighter.service.AnimalService;
import com.animalfighter.utils.Fight;

import java.util.List;


public class Main {

	public static void main(String[] args) {

		IAnimalService animalService = new AnimalService();


		Cat murzik = new Cat("Мурзик", 5, 12, 20);
		animalService.addAnimal((Animal) murzik);

		Cat vaska = new Cat("Васька", 4, 11, 14);
		animalService.addAnimal((Animal) vaska);

		Animal animal = animalService.getByName("Васька");
		String name1 = animal.getName();
		System.out.println(name1);

		Dog dog1 = new Dog("Жучка", 2, 12, 20);
		animalService.addAnimal((Animal) dog1);
		Dog dog2 = new Dog("Барбос", 3, 11, 20);
		animalService.addAnimal((Animal) dog2);

		// call List animalService
		for (Animal an : animalService.getAnimals()) {
			System.out.print(an.getNametype() + "'s name is  " + an.getName() + " says ");
			an.saySmth();
		}

		// Complex
		System.out.println("==========Fight =========================");
		Fight fight = new Fight();
		List<Animal> animalFight = animalService.getAnimals();
		int sizeAnimals = animalFight.size();
		for(int i = 0 ; i < sizeAnimals -1 ; i++){
			Animal fighter1 = animalFight.get(i);
			for(int j = 1 ; j < sizeAnimals ; j++){
				if( i != j ){
					Animal fighter2 = animalFight.get(j);
					while (fighter1.getStrength() > 0 && fighter2.getStrength() > 0) {
						fight.fightAnimal(fighter1, fighter2);
						fight.fightAnimal(fighter2, fighter2);
					}
					if (fighter1.getStrength() > fighter2.getStrength()) {
						System.out.println(fighter1.getNametype() + " " + fighter1.getName() + " Great victory! ");
					} else {
						System.out.println(fighter2.getNametype() + " " + fighter2.getName() + " Great victory! ");
					}

				}
			}
		}

	}
}