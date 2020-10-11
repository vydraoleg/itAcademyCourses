package com.animalfighter;

import com.animalfighter.entities.Animal;
import com.animalfighter.utils.SerializationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This main method returns information about last saved Animals in Main program in *.info files
 */
public class MainSerialisation {
    public static void main(String[] args) throws IOException {

        try (Stream<Path> paths = Files.walk(Paths.get("e:\\Java\\GitHub\\"))) {
            List<String> result = paths.filter(Files::isRegularFile)
                    .map(x -> x.toString())
                    .filter(f -> f.endsWith(".info"))
                    .collect(Collectors.toList());
            result.forEach(System.out::println);
            for (String resultFile : result) {
                Animal fighter = new SerializationUtil().deserialize(resultFile);
            }
        }
    }
}
