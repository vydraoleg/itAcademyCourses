package oleg;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

public class Less200930 {
    public static void main(String[] args) {
//        System.out.println(" 3333333");
        try {
            Map<String, String> lines = Files.lines(Paths.get("d:\\oleg\\txt.txt"))
                    .collect(Collectors.toMap(x -> x, y -> y));
//        Integer.parseInt("dfgdfgdf");  NumberFormatException
        } catch (IOException e){
            e.getMessage();
        }
    }
}
