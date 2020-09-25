package com.catfighter.utils;

public class CriticalHitCounter {
    public static boolean isCritical(){
//        RandomStringUtils
        int randomNum = (int) Math.random()*2-1 ;
        return randomNum <= 9 && randomNum >= 5;

    }
}
