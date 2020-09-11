package com.itacademy.firstgit;

import com.itacademy.firstgit.animals.*;

import java.util.*;

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
//		System.out.println(!strings.isEmpty());
//		System.out.println("bobik "+animals.contains(vaska));
        dogs.subList(0, 1);
//        List<String> strings = new ArrayList<>();
        LinkedList<String> strings = new LinkedList<>();
        strings.add("murzik");
        strings.add("vaska");
        strings.add("barsik");
        for( String str:strings){
            str.concat(" is a cat");
            System.out.println(str);
        }
        Iterator stringIterator = strings.iterator();
        while(stringIterator.hasNext()){
            System.out.println(stringIterator.next());
        }
        strings.add("barsik11");
        Iterator stringIterator1 = strings.iterator();  // каждый раз новый итератор создается !!!!
        while(stringIterator1.hasNext()){
            System.out.println(stringIterator1.next());
        }

        String[] stringArray = {"cat", "dog", "pig"};
        List<String> str1=  Arrays.asList(stringArray);
        for (String str : strings){
            if(str.equals("vaska")){
//                strings.remove(str);
                System.out.println(str);
            }
        }
////////////////////////////////////////////////////////////////////////////////////
        Set<String> strings1 = new HashSet<>();
        strings1.add("murzik10");
        strings1.add("murzik11");
        strings1.add("murzik12");
        strings1.add("murzik13");
        strings1.add("murzik14");
        strings1.add("murzik15");
        strings1.add("murzik15");
        for (String str : strings1) {
            System.out.println(str);
        }
//        strings1.stream().sorted()
        String murzik3 = null;
        for (String str: strings1) {
            if(str.equals("murzik13")){ murzik3 = str; break;}
        }
        System.out.println(murzik3);
////////////////////////////////////////////////////////////////////////////////////
        Map<Integer,String> strings2 = new HashMap<>();
    }
}