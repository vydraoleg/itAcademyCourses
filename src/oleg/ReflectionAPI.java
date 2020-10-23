package oleg;

import com.catfighter.entities.Cat;

import java.lang.reflect.Field;


public class ReflectionAPI {
    public static void main(String[] args) throws ClassNotFoundException {
        Cat cat = new Cat();
        int age = cat.getAge();
        String name = cat.getName();

/*
        Class clazz = cat.getClass();
        Class clazz2 = Class.forName("com.catfighter.entities.Cat");
        Class clazz3 = Cat.class;
        Class clazz4 = ReflectionAPI.class;
        clazz3.getDeclaredFields();
        clazz3.getDeclaredMethods();
*/
        try {
            Field field = cat.getClass().getDeclaredField("name");
            field.setAccessible(true);
            name = (String) field.get(cat);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.printf("Cat name is %s ",name);
        String stop = "stop";
    }
}