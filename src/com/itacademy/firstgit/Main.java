package com.itacademy.firstgit;

import com.itacademy.firstgit.animals.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//		System.out.println("Hello, world!");

//        Animal an = new Animal();  WRONG

//		List<Animal> animals2 = new ArrayList<>();// смотрит что слево
//		List animals = new ArrayList<>();// смотрит что слево

        @SuppressWarnings("unused") // не будет предупреждения
                Animal murzik = new Cat();
        Animal bobik = new Dog();
        Animal funtik = new Pig();

//		Animal[] animals = {murzik,bobik,funtik};

        Cat vaska = new Cat();
        vaska.setAge(5);
        vaska.setName("Vaska");

        Dog sharik = new Dog();
        sharik.setAge(4);
        sharik.setName("Sharik");

        Pig borka = new Pig();
        borka.setAge(4);
        borka.setName("Borka");

        List<Animal> cats = new ArrayList<>();// смотрит что слево
        cats.add(murzik);
        cats.add(vaska);

        List<Animal> dogs = new ArrayList<>();// смотрит что слево
        dogs.add(sharik);
        dogs.add(bobik);
        dogs.add(sharik);
        dogs.add(bobik);

        List<Animal> animals = new ArrayList<>();// смотрит что слево
        animals.addAll(cats);
        animals.addAll(dogs);
        cats.remove(vaska);
        animals.remove(vaska); // не работает
//        animals.removeAll(dogs);
//        animals.set(0, bobik);
        dogs.subList(0, 1);
        List<String> strings = new ArrayList<>();
        strings.add("murzik");
        strings.add("vaska");
        strings.add("barsik");
        strings.add("murzik");
        strings.add("vaska");
        strings.add("barsik");
		System.out.println(!strings.isEmpty());
		System.out.println("bobik "+animals.contains(vaska));

        String str = "stop";
    }
}