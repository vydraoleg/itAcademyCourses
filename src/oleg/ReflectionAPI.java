package oleg;

import com.entity.Pat;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ReflectionAPI {
    public static void main(String[] args) {
        Pat pat = new Pat(1, "Tobzik");
//        int age = cat.getAge();
//        Pat pat = null;
        Pat pat1 = null;
        String nameClass = Pat.class.getName();
//        pat.getClass().getName()
//        Class clazz = cat.getClass();

// получаем ссылку на класс и достпу к private constructor
        try {
            Class<?> clazz2 = Class.forName(nameClass);  // "com.catfighter.entities.Cat"
            Class<?>[] parameters = {int.class, String.class};
            Constructor<?>[] constructors = clazz2.getConstructors();
            Constructor<?> constructor = clazz2.getDeclaredConstructor(parameters);
            constructor.setAccessible(true);

            pat1 = (Pat) clazz2.getConstructor(parameters).newInstance(4, "Vaska");
            Pat cat2 = (Pat) clazz2.getConstructor(int.class, String.class).newInstance(4, "Vaska");
//            cat1 = (Cat)clazz2.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        Class clazz3 = Pat.class;


        //        Class clazz4 = ReflectionAPI.class;
//        clazz3.getDeclaredFields();
//        clazz3.getDeclaredMethods();
        String name = "";
//
        try {
//            Field[] fields = cat.getClass().getDeclaredFields();
            Field field = pat.getClass().getDeclaredField("name");
            field.setAccessible(true);
            name = (String) field.get(pat);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.printf("Cat name is %s \n", name);

        String stop = "stop";
        try {
            Method method = pat.getClass().getDeclaredMethod("printPat");
            method.setAccessible(true);
            method.invoke(pat);
        } catch (NoSuchMethodException|IllegalAccessException|InvocationTargetException e) {
//        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

}