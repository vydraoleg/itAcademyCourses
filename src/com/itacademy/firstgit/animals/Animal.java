package com.itacademy.firstgit.animals;

public abstract class Animal{

    private String name;
    private int age;

    public void saySmth(){
        System.out.println("some abstract animal voice");
    }

    public String getName(int i){
        return "Hello";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}
