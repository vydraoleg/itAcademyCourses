package com.entity;

public class ThreadTest extends Thread{
    public Double inter;
    public ThreadTest(Double inter){ this.inter = inter+10;}

    public Double getInter() {
        return inter;
    }

    public void setInter(Double inter) {
        this.inter = inter;
    }

    @Override
    public void run(){
        System.out.printf("Message 1 from extended Thread %s %f \n",Thread.currentThread().getName(),inter);
        System.out.println("Message 2 from extended Thread "+this.getName());
        System.out.println("Message 3 from extended Thread "+this.getName());
        System.out.println("Message 4 from extended Thread "+this.getName());
        System.out.println("Message 5 from extended Thread "+this.getName());
        System.out.println("Message 6 from extended Thread "+this.getName());
        System.out.println("Message 7 from extended Thread "+this.getName());


    }
}
