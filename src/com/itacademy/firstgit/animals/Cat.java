package com.itacademy.firstgit.animals;

public class Cat extends Animal{

//	@Override
	public void saySmth(){
		System.out.println("Meow");
	}

	public Cat(){
	}

    public Cat(String pname, int page){
    	setName(pname);
    	setAge(page);
	}

}