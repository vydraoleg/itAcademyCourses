package oleg;

import java.util.*;

public class Lesson200911 {
    public static void main(String[] args) {
        // основные
        LinkedList list1 = new LinkedList(); // каждый элемент + хранит ссылку на next and previous element
        ArrayList list2 = new ArrayList(); // динамический массив ЧАЩЕ
        // SingleToneList - хранит одно значение
        List<Integer> list = new ArrayList<Integer>() {
            {
                add(100);
                add(150);
                add(80);
            }
        };
        for (int i = 0; i < 7; i++) {
            list.add((int) (Math.random() * 100));
        }

        for (Number ind : list) {
            System.out.print(ind+" ");
        }
        System.out.println(" ");

        Collections.shuffle(list);
        for (Number ind : list) {
            System.out.print(ind+" ");
        }
        System.out.println(" ");
        Collections.sort(list);

        Iterator<Integer> it = list.iterator();
        Integer res;
        while (it.hasNext()) {
            res = (int) it.next();
            System.out.print(res+" ");
        }
        System.out.println(" ");
    }
}
