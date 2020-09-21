package com.itacademy.firstgit;

import com.itacademy.firstgit.animals.Animal;
import com.itacademy.firstgit.animals.Cat;
import com.itacademy.firstgit.animals.Dog;
import com.itacademy.firstgit.animals.Pig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MainLesson5_01 {
    public static void main(String[] args) {
        Animal<Integer> bobik = new Dog();
        bobik.setName("Bobik");
        Animal<Integer> funtik = new Cat();


//		Animal[] animals = {murzik,bobik,funtik};

        Cat vaska = new Cat();
        vaska.setAge((Integer)5);
        vaska.setName("Vaska");

        Dog sharik = new Dog();
        sharik.setAge((Integer)4);
        sharik.setName("Sharik");

        Pig borka = new Pig();
        borka.setAge((Integer)4);
        borka.setName("Borka");

        List<Animal> cats = new ArrayList<>();// смотрит что слево
        cats.add(funtik);
        cats.add(vaska);

        List<Animal> dogs = new ArrayList<>();// смотрит что слево
        dogs.add(sharik);
        dogs.add(bobik);

        List<Animal> animals = new ArrayList<>();
        animals.addAll(dogs);
        animals.addAll(cats);

        List<String> dogNames = animals.stream()
                .filter(x -> x instanceof Dog)
                .map(x -> {
                    if (x.getName() == null) {
                        x.setName("DefaultName");
                    }
                    return x.getName();
                })
                .collect(Collectors.toList());
//                .forEach(System.out::println)
        ;

//        Map<String, Integer> animalMap =animals.stream()
//                .collect(Collectors.toMap(Animal::getName, Animal::getAge));
        bobik.getName().chars();

        Map<String, Animal> animalMap1 = animals.stream()
                .collect(Collectors.toMap(Animal::getName, Function.identity()));
        System.out.println(animalMap1);
    }
}
