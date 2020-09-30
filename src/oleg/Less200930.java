package oleg;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
//import java.util.Calendar; @Deprecated
//import java.util.Date;  @Deprecated
//import java.sql.Date;@Deprecated
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.Collectors;

public class Less200930 {
    public enum TypeOfAnimals{
        CAT, DOG, MONKEY
    }
    @Deprecated
    private Less200930(){}  // не даст создать класс

    public static void main(String[] args) {
        LocalDate date = LocalDate.ofYearDay(2020, 256);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse("2020-01-20",formatter);
        System.out.println(date1);


        try {
            Map<String, String> lines = Files.lines(Paths.get("d:\\oleg\\txt.txt"))
                    .collect(Collectors.toMap(x -> x, y -> y));
//        Integer.parseInt("dfgdfgdf");  NumberFormatException
        } catch (IOException e){
            e.getMessage();
        }
    }
}
