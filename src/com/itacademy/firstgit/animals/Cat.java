package com.itacademy.firstgit.animals;

import com.itacademy.firstgit.utils.api.ISaySomething;

public class Cat extends Animal<Integer> implements ISaySomething {

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

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Cat with name ")
                .append(this.getName())
                .append(" age of ")
                .append(this.getAge()).toString();
    }
}
