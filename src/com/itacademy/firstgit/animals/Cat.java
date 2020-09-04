package com.itacademy.firstgit.animals;

public class Cat extends Animal implements ISaySomething{

    @Override
    public void saySmth(){
        System.out.println("say MEOW");
    }
    public void  catchMouse(){
        System.out.println("Got the mouse!");
    }

    @Override
    public void play(){
        System.out.println("Cat is playing");
    }
}
