package com.itacademy.firstgit.animals;

public class SqrtCount {

// Перегрузка методов
    public static double countSqrt (int number){
        return Math.sqrt( number) ;
    }
    public static double countSqrt (long number){
        return Math.sqrt( number) ;
    }
    public static double countSqrt (float number){
        return Math.sqrt( number) ;
    }
    public static double countSqrt (double number){
        return Math.sqrt( number) ;
    }
/*
    public static String count(String[] arr){
        return null;
    }
*/
    public static String count(String... arr){
        return "11111";
    }
}

/*
        System.out.println(SqrtCount.countSqrt(intNumber));
                System.out.println(SqrtCount.countSqrt(longNumber));
                System.out.println(SqrtCount.countSqrt(floatNumber));
                System.out.println(SqrtCount.countSqrt(doubleNumber));

                String a = SqrtCount.count("23423423", "ewfwefwefew");
*/

