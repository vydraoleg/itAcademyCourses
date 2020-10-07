package com.animalfighter.utils;

import com.animalfighter.entities.Animal;

import java.io.*;
//"..\\txt1.txt"
public class SerializationUtil {
    public boolean serialize(Animal animal,String nFile) {

        try (ObjectOutputStream objectOutputStream
                     = new ObjectOutputStream(new FileOutputStream(nFile))){
            System.out.println(animal.toString());
            objectOutputStream.writeObject(animal);
            System.out.println("person was serialized");
        } catch (IOException e) {   // FileNotFoundException |
            e.printStackTrace();
            return false;

        }

        System.out.println("person current");
        System.out.println(animal.toString());
        return true;
    }
//try with resources  ;

    public Animal deserialize(String nFile) {
        try (ObjectInputStream objectInputStream
                     = new ObjectInputStream(new FileInputStream(nFile))){
            return  (Animal) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
