package com.animalfighter.utils;

import com.animalfighter.entities.Animal;

import java.io.*;

public class SerializationUtil {
    public boolean serialize(Animal animal,String nFile) {

        try (ObjectOutputStream objectOutputStream
                     = new ObjectOutputStream(new FileOutputStream(nFile))){
            System.out.println(animal.toString());
            objectOutputStream.writeObject(animal);
            System.out.println(String.format("animal %s named %s was Serialized",animal.getNametype(),animal.getName()));
        } catch (IOException e) {   // FileNotFoundException |
            System.out.println(String.format("Can not write file: file: %s",nFile));
            return false;
        }
        return true;
    }
//try with resources  ;

    public Animal deserialize(String nFile) {
        try (ObjectInputStream objectInputStream
                     = new ObjectInputStream(new FileInputStream(nFile))){
            Animal animal = (Animal) objectInputStream.readObject();
            System.out.println(String.format("animal %s named %s was Deserialized",animal.getNametype(),animal.getName()));
            return  animal;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(String.format("Unexisting file: %s",nFile));
            return null;
        }
    }

}
