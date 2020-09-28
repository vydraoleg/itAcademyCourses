package com.animalfighter.entities;

public class Cat extends Animal {

    @Override
    public void saySmth() {
        System.out.println("Meow");
    }

    public Cat() {
        setNametype("Cat");
    }

    public Cat(String name, int age, int weight, int strenght) {
        this();
        setName(name);
        setAge(age);
        setWeight(weight);
        setStrength(strenght);
    }


    public Cat(String pname, int page) {
		this();
        setName(pname);
        setAge(page);
		setAge(0);
		setWeight(0);
	}

    @Override
    public String toString() {
        return "Cat info - name:" + getName() + " age: " + getAge() + " strength: " + getStrength();
    }

}