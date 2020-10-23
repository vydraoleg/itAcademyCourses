package com.itacademy.firstgit.animals;

import com.itacademy.firstgit.utils.api.ISaySomething;

public class Cat {
    private  int age;
    private String name ="Murzik";

    public int getAge() {
        return age;
    }

    public Cat(int age, String name){
    }

    public void saySmth(){
        System.out.println("say MEOW");
    }
    public void  catchMouse(){
        System.out.println("Got the mouse!");
    }


    public String toString() {
        return new StringBuilder()
                .append("Cat with name ")
                .append(" age of ")
                .append(this.getAge()).toString();

    }
    private void printCat(){

    }
}
