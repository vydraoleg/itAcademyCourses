package com.itacademy.firstgit;

import com.itacademy.firstgit.animals.*;

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

/*
builder
        Animal2 an =Animal2.builder()
                .age(5)
                .buil();
accessors
Map = Set <Map Entry>
*/
   Map<String, Integer> map = new HashMap<>();
        map.put("Hello1",1);
        map.put("Hello2",2);
        map.put("Hello3",3);
        map.put("Hello4",5);
        map.put("Hello5",4);
        for (Map.Entry<String, Integer> entry: map.entrySet()  ) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
//        System.out.println(map);
//        System.out.println(map.get(null));
    }
}