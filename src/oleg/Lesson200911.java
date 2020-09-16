package oleg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Lesson200911 {
    public static void main(String[] args) {
        // основные
         LinkedList list1 = new LinkedList(); // каждый элемент + хранит ссылку на next and previous element
         ArrayList list2 = new ArrayList(); // динамический массив ЧАЩЕ
        // SingleToneList - хранит одно значение
         List<Integer> list = new ArrayList<Integer>(){
             {
                 add(100);
                 add(150);
                 add(80);
             }
         };
         for (int i = 0; i<20;i++){
             list.add((int)(Math.random()*100));
         }
         for(Number ind : list){
             System.out.println(ind);
         }
        Iterator<Integer> it = list.iterator();
        Integer res;
        while ( it.hasNext()){
            res = (int)it.next() ;
            System.out.println(res);
        }
    }
}
