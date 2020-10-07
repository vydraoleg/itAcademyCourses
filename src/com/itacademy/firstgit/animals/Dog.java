package com.itacademy.firstgit.animals;

import java.io.Serializable;

public class Dog extends Animal<Integer> implements Serializable {

    private static final long serialVersionUID = -121232131231213l;

    private transient int salary;
//    private int salary;
    public Dog() {
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name=" + this.getName() +
                "salary=" + salary +
                "age=" + this.getAge() +
                '}';
    }

    public Dog(String name, int age, int salary) {
        this.setName(name);
        this.setAge(age);
        this.salary = salary;

    }

    @Override
    public void saySmth() {
        System.out.println("Bark!");
    }

    public void catchCat(Cat cat) {
        if (isYoungCat(cat)) {
            System.out.println("Failed to catch cat");
        } else if (cat.getName() != null) {
            System.out.println("RIP " + cat.getName());
        }

    }

    public void playWithCat(Cat cat) {
        if (isYoungCat(cat)) {
            System.out.println("Failed to catch cat");
        } else if (cat.getName() != null) {
            System.out.println("play with " + cat.getName());
        }
    }

    private boolean isYoungCat(Cat cat) {
        return cat.getAge() > 3 && cat.getAge() < 5;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
