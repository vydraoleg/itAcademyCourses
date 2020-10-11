package com.entity;

public class RunnableTest implements Runnable{
    @Override
    public void run(){
        System.out.println("Message 1 from extended Runnable "+Thread.currentThread().getName());
        System.out.println("Message 2 from extended Runnable "+Thread.currentThread().getName());
        System.out.println("Message 3 from extended Runnable "+Thread.currentThread().getName());
        System.out.println("Message 4 from extended Runnable "+Thread.currentThread().getName());
        System.out.println("Message 5 from extended Runnable "+Thread.currentThread().getName());
        System.out.println("Message 6 from extended Runnable "+Thread.currentThread().getName());
        System.out.println("Message 7 from extended Runnable "+Thread.currentThread().getName());
        System.out.println("Message 8 from extended Runnable "+Thread.currentThread().getName());
        System.out.println("Message 9 from extended Runnable "+Thread.currentThread().getName());
        System.out.println("Message 10 from extended Runnable "+Thread.currentThread().getName());
    }
}
