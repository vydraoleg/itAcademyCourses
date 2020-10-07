package oleg;

import com.entity.Adult;
import com.entity.Child;
import com.entity.Person;

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LessSerial {
    public static void main(String[] args) {
        Child child1 = new Child("Ivan",5,"Car");
        Child child2 = new Child("Masha",3,"Doll");
//        List<Child> children = Stream.of(child1,child2).collect(Collectors.toList());
        Adult person = new Adult("Vasili",10,Stream.of(child1,child2).collect(Collectors.toList()));

//        List<Child> children = new ArrayList<Child>();
//        children.add((Child) child1);
//        children.add((Child) child2);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("..\\txt1.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            System.out.println(person.toString());
            objectOutputStream.writeObject(person);

            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("person was serialized");
        } catch ( IOException e) {   // FileNotFoundException |
            e.printStackTrace();
        }
        person.setAge(35);

        System.out.println("person current");
        System.out.println(person.toString());

        try {
            FileInputStream fileInputStream = new FileInputStream("..\\txt1.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            person = (Adult) objectInputStream.readObject();
            System.out.println(person.toString());

            objectInputStream.close();
            fileInputStream.close();

        } catch (IOException | ClassNotFoundException e) {   // FileNotFoundException |
            e.printStackTrace();
        }



    }
}
