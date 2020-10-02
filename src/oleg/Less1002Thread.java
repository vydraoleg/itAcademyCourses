package oleg;

import com.catfighter.entities.Cat;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


//import lombok.*;

//@Slf4j2
public class Less1002Thread {
    public static void main(String[] args) throws IOException {
        Cat cat = new Cat();
    /*      cat.setName("Vaska");
        cat.setAge(25);
      try (FileOutputStream fileOutputStream = new FileOutputStream("d:\\oleg\\txt.txt")){
            byte[] buffer = cat.getName().getBytes();
            //System.out.println(fileOutputStream.toString());
            fileOutputStream.write(buffer);
            fileOutputStream.write('\n');
            Integer age = cat.getAge();
            fileOutputStream.write( age.toString().getBytes() );
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter fileWriter = new FileWriter("d:\\oleg\\txt.txt")){
            fileWriter.write(cat.getName()+'\n');
            Integer ageOne = cat.getAge();
            fileWriter.write(ageOne.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

     */
        try (FileReader fileReader = new FileReader("d:\\oleg\\txt.txt")){

            StringBuilder builder = new StringBuilder();
                    Integer ageOne = cat.getAge();
            int in;
            while((in = fileReader.read()) != -1){
                builder.append((char)in);
            }
            System.out.println(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("d:\\oleg\\txt.txt"))){
            String name = bufferedReader.readLine();
            System.out.println(name);
            Integer age = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Age =" + age);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Scanner
        // implements Closable
/*        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Enter name: ");
            cat.setName(reader.readLine());
            System.out.println("Enter Age: ");
            cat.setAge(Integer.parseInt(reader.readLine()));
            System.out.println(cat.toString());
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
//        } finally {
//            try {
//                reader.close();
//            } catch (IOException e) {
//                System.out.println(e.getMessage());
//            }
        }

 */
    try{
//        File file = new File();
        Files.readAllLines(Paths.get("txt.txt"))
                .stream()
                .forEach(System.out::println);
        System.out.println(Files.readAllLines(Paths.get("d:\\oleg\\txt.txt"))
                .stream().count());
    } catch (IOException e) {
        e.printStackTrace();
    }

    }
}
