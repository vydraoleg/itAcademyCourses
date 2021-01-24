package com.it.spring;

public class ClassicalMusic implements Music {
    public void doMyInit(){
        System.out.println("Doing my initialisation");
    }
    public void doMyDestroy(){
        System.out.println("Doing my destraction");
    }
    @Override
    public String getSong() {
        return "Hungarian rhapsody";
    }
}
