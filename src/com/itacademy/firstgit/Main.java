package com.itacademy.firstgit;

import com.itacademy.firstgit.animals.*;

public class Main {

	public static void main(String[] args) {
//		System.out.println("Hello, world!");

//        Animal an = new Animal();  WRONG
        Animal murzik = new Cat();
		Animal bobik = new Dog();
		Animal funtik = new Pig();

		Cat vaska = new Cat();
		vaska.setAge(5);
		vaska.setName("Vaska");

//		Cat murzik = new Cat("Murzik",2);

		Dog sharik = new Dog();
		sharik.setAge(4);
		sharik.setName("Sharik");

		Pig borka = new Pig();
		borka.setAge(4);
		borka.setName("Borka");
		int intNumber = -25;
        long longNumber = 258965940869405L;
        float floatNumber = 55.7834535F;
		double doubleNumber = 55.78;

/*
		System.out.println("Cat's name is " + vaska.getName());
		System.out.println("Cat's name is " + murzik.getName());
		System.out.println("Dog's name is " + sharik.getName());
		System.out.println("Pig's name is " + borka.getName());
*/
//    vaska.saySmth();
//    vaska.catchMouse();
//    sharik.saySmth();
//    sharik.catchCat(vaska);
//    borka.saySmth();
//    borka.sleep();

/*
    murzik.saySmth();
	bobik.saySmth();
	funtik.saySmth();
*/

    Animal[] animals = {murzik,bobik,funtik};

    for(Animal an:animals){
    	an.saySmth();
	}

	Animal[] animals1 = {vaska,sharik,borka};
	for(Animal an:animals1){
		an.saySmth();
		if(an instanceof Cat)  ((Cat) an).catchMouse();
		if(an instanceof Dog)  ((Dog) an).catchCat(vaska);
		if(an instanceof Pig)  ((Pig) an).sleep();
	}
  }
}