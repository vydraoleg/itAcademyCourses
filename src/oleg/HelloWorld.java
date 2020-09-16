package oleg;

import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
    private static int i = 050;

    public enum SmtnConst {i}

    public static void main(String[] args) {
        StringBuilder j = new StringBuilder(" Addition");
        System.out.println(+i);
        System.out.println("I \"like\" Java! " + j);
        boolean rt = true;
        System.out.println("I like Java! " + rt);

        String[] array = new String[5];
// Generic Collection
//        List list = new ArrayList();  // список объектов
        List<Integer> list = new ArrayList();
        List<String> list1 = new ArrayList();
        List<? extends Number> list2 = new ArrayList();

        list.add(i);
        list.add(34);

    }
}
