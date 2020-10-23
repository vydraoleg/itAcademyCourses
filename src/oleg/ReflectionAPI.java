package oleg;

import com.itacademy.firstgit.animals.Cat;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ReflectionAPI {
    public static void main(String[] args) {
//        Cat cat = new Cat(1,"11");
//        int age = cat.getAge();
        Cat cat = null;
        Cat cat1 = null;
        String nameClass=Cat.class.getName();
//        cat.getClass().getName()
//        Class clazz = cat.getClass();


        try {
            Class<?> clazz2 = Class.forName(nameClass);  // "com.catfighter.entities.Cat"
            Class<?>[] parameters = {int.class, String.class};
            Constructor<?>[] constructors = clazz2.getConstructors();
            Constructor<?> constructor = clazz2.getDeclaredConstructor(parameters);
            constructor.setAccessible(true);

            cat1 = (Cat)clazz2.getConstructor(parameters).newInstance(4,"Vaska");
            Cat cat2 = (Cat) clazz2.getConstructor(int.class, String.class).newInstance(4,"Vaska");
//            cat1 = (Cat)clazz2.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        Class clazz3 = Cat.class;

        //        Class clazz4 = ReflectionAPI.class;
//        clazz3.getDeclaredFields();
//        clazz3.getDeclaredMethods();
        String name="";
        try {
//            Field[] fields = cat.getClass().getDeclaredFields();
            Field field = cat.getClass().getDeclaredField("name");
            field.setAccessible(true);
            name = (String) field.get(cat);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.printf("Cat name is %s ",name);

        String stop = "stop";
        try {
            Method method = cat.getClass().getDeclaredMethod("printCat");
            method.setAccessible(true);
            method.invoke(cat);
        } catch (NoSuchMethodException|IllegalAccessException|InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}