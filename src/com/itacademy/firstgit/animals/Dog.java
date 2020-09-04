package com.itacademy.firstgit.animals;

public class Dog extends Animal{
    @Override
    public void saySmth(){
        System.out.println("Bark!");
    }
    public void catchCat(Cat cat){
        if(isYoungCat(cat) ){
            System.out.println("Failed to catch cat");
        } else
            if(cat.getName() != null) {
                System.out.println("RIP " + cat.getName());
            }

    }
    public void playWithCat(Cat cat){
        if(isYoungCat(cat) ){
            System.out.println("Failed to catch cat");
        } else
        if(cat.getName() != null) {
            System.out.println("play with " + cat.getName());
        }
    }
    private boolean isYoungCat(Cat cat){
        return cat.getAge()>3 && cat.getAge() < 5;
    }
}
