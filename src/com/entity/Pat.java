package com.entity;

public class Pat {
    private int age;
    private String name;

    public Pat(int age, String name){
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void printPat(){
        System.out.printf(" Pat has name %s and its age %d\n",this.name,this.age);
    }
}
