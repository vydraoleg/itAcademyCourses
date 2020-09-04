package com.itacademy.firstgit.animals;

public class Dog extends Animal{
    @Override
    public void saySmth(){
        System.out.println("Bark!");
    }
    public void catchCat(Cat cat){
        System.out.println("RIP "+cat.getName());
    }
}
