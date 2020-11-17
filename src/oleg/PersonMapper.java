package oleg;


import com.entity.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PersonMapper {
    public static void main(String[] args) throws IOException{

        byte[] jsonData = Files.readAllBytes(Paths.get("person.txt"));
//        ObjectMapper objectMapper = new ObjectMapper();
//        Person person = objectMapper.re

    }
}
