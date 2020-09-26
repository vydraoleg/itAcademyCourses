package com.catfighter.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CriticalHitCounter {
    public static boolean isCritical() {
//        RandomStringUtils
        int randomNum = (int) Math.random() * 2 - 1;
        return randomNum <= 9 && randomNum >= 5;

    }

    public static void doSmth() throws IOException, NullPointerException{
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // try with resources   должен имплементить autoclosable
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String s = reader.readLine();
            System.out.println("User printed " + s);
        } catch (IOException e) {
            e.printStackTrace();
            throw  new IOException();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
