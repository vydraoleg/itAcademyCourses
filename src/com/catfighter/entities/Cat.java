package com.catfighter.entities;

public class Cat extends Animal {

//	@Override
	public void saySmth(){
		System.out.println("Meow");
	}

	public Cat(){
	}

	public Cat(String name, int age, int strength){
	}

	public Cat(String pname, int page){
    	setName(pname);
    	setAge(page);
	}

	@Override
	public String toString(){
		return "Cat info - name:"+getName()+" age: "+getAge() + " strength: "+ getAge();
	}

}