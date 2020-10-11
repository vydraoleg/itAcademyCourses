package com.entity;

public class ThreadTest extends Thread{
    @Override
    public void run(){
        System.out.printf("Message 1 from extended Thread %s \n",Thread.currentThread().getName());
        System.out.println("Message 2 from extended Thread "+this.getName());
        System.out.println("Message 3 from extended Thread "+this.getName());
        System.out.println("Message 4 from extended Thread "+this.getName());
        System.out.println("Message 5 from extended Thread "+this.getName());
        System.out.println("Message 6 from extended Thread "+this.getName());
        System.out.println("Message 7 from extended Thread "+this.getName());

    }
}
