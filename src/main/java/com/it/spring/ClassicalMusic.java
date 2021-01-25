package com.it.spring;

public class ClassicalMusic implements Music {
    private ClassicalMusic(){}
    public static ClassicalMusic getClassicalMusic(){
        return new ClassicalMusic();
    }
    public void doMyInit(){ System.out.println("Doing my initialisation"); }
    public void doMyDestroy(){
        System.out.println("Doing my destraction");
    }

    @Override
    public String getSong() {
        return "Hungarian rhapsody";
    }
}
