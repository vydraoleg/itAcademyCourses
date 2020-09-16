package com.itacademy.firstgit;

import com.itacademy.firstgit.animals.Animal;
import com.itacademy.firstgit.animals.Cat;
import com.itacademy.firstgit.animals.Dog;
import com.itacademy.firstgit.animals.Pig;

import java.util.*;

public class MainLes4 {

    public static void main(String[] args) {

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
//        borka.hashCode();
//        borka.equals(sharik)

        List<Animal> cats = new ArrayList<>();// смотрит что слево
        cats.add(murzik);
        cats.add(vaska);

        List<Animal> dogs = new ArrayList<>();// смотрит что слево
        dogs.add(sharik);
        dogs.add(bobik);
        dogs.add(sharik);
        dogs.add(bobik);

    }
}