package com.catfighter;

import com.catfighter.api.service.ICatService;
import com.catfighter.entities.Animal;
import com.catfighter.entities.Cat;
import com.catfighter.service.CatService;


public class Main {

	public static void main(String[] args) {

		ICatService catService = new CatService();

		//		System.out.println("Hello, world!");

//        Animal an = new Animal();  WRONG
//        Animal an = new Cat();

//		Cat vaska = new Cat();
//		vaska.setAge(5);
//		vaska.setName("Vaska");

		Cat murzik = new Cat("Murzik",2);
		Cat cat = catService.getByName("Hi");
		String name1 = cat.getName();


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

	}
}