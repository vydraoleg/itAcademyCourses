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

        System.out.println(vaska);
        System.out.println(borka);
/*
builder
        Animal2 an =Animal2.builder()
                .age(5)
                .buil();
accessors
Map = Set <Map Entry>
*/
        Animal2 an = new Animal2();

   Map<String, Integer> map = new HashMap<>();
        map.put("Hello1",1);
        map.put("Hello2",2);
        map.put("Hello3",3);
        map.put("Hello4",4);
        map.put("Hello5",5);
        for (Map.Entry<String, Integer> entry: map.entrySet()  ) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
/*
        for (String key: map.keySet()  ) {
            System.out.println(key);
        }
        for (Integer val1: map.values() ) {
            System.out.println(val1);
        }
*/
        Collection<Integer> values =  map.values();
//        List<Integer> values = (List<Integer>) map.values();

        System.out.println(map.containsKey("Hello1"));
//        System.out.println(map.get(null));
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
//        entrySet.remove(Map.Entry<                >); // will delete in main map
        for (Map.Entry<String, Integer> entry: entrySet  ) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


/*
        System.out.println(map);
        System.out.println(entrySet);
        map.put("Hello6",6);
        System.out.println(map);
        System.out.println(entrySet);
*/
//        map.forEach();
        Integer i = map.get("Hello8");
        System.out.println( i );
        System.out.println( map.getOrDefault("Hello4",0) );
    }
}