package com.animalfighter.utils;

import com.animalfighter.entities.Animal;
import com.animalfighter.entities.Cat;
import com.animalfighter.entities.Dog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {

    List<Animal> animalList;

    public ReadFromFile() {
        animalList = new ArrayList<Animal>();
    }

    private String readNameOfFile() {
        String fileName = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter file name: ");
            fileName = reader.readLine();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            return fileName;
        }
    }

    public List<Animal> AnimalFromFile() {
        String fileName = readNameOfFile();
        if (fileName.length() > 0) {
            try {
                List<String> lines =
                        Files.readAllLines(Paths.get(readNameOfFile()), StandardCharsets.UTF_8);
                for (String string : lines) {
                    if (string.length() > 3) {
                        String[] tempString = string.split(",");
                        switch (tempString[0].trim()) {
                            case "Dog":
                                animalList.add(new Dog(tempString[1], Integer.parseInt(tempString[2]), Integer.parseInt(tempString[3]),
                                        Math.round(Math.random() * Integer.parseInt(tempString[3]))));
                                break;
                            case "Cat":
                                animalList.add(new Cat(tempString[1], Integer.parseInt(tempString[2]), Integer.parseInt(tempString[3]),
                                        Math.round(Math.random() * Integer.parseInt(tempString[3]))));
                                break;
                            default:
                                System.out.println(tempString[0]);
                                throw new IllegalStateException("Unexpected value: " + tempString[0]);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return animalList;
    }

}
