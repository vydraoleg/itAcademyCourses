package oleg;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LessMap {
    public static void main(String[] args) {
        String str = "проверка работы системы системы, работы проверка лучше привет привет привет";
        Map<String, Integer> map = new HashMap<>();
        String delimiter = "[,. ]";
        String[] subStr = str.split(delimiter);
        for (int i = 0; i < subStr.length; i++) {
            if (!subStr[i].isEmpty()) {
                map.put(subStr[i], map.containsKey(subStr[i]) ? map.get(subStr[i]) + 1  : 1);
            }
        }
        System.out.println(map);
        Integer maxCount = 0;
        String  maxKey="";

        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();

//        for (Map.Entry<String, Integer> entry: map.entrySet()  ) {
        for (Map.Entry<String, Integer> entry: entrySet  ) {
            if(entry.getValue() > maxCount){
                maxCount = entry.getValue();
                maxKey=entry.getKey();
            }
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println(" Maximum number of worlds in the text <" +maxKey + "> = " + maxCount);
        Set setB = new LinkedHashSet(){{
            add("b123er");
            add("b223");
            add("b145");
            add("b134");
        }};;
        Set setC = new TreeSet(){{
            add("c123er");
            add("c223");
            add("c145");
            add("c134");
        }};;
        Set<String> set = new HashSet<>(){{
            add("123er");
            add("223");
            add("145");
            add("134");
        }};
        for (String res: set)   System.out.println(res);
//        Stream<String> stream = set.stream();
//        stream.forEach((element) -> System.out.println(element));
        set.stream().filter(x->x.toString().length()==3).forEach((x) -> System.out.println(x));
        setB.stream().forEach(xx-> System.out.println(xx));

        String[] array = {"Java", "Vydraaaaaaaaaaaaa"};
        Stream<String> streamOfArray = Arrays.stream(array);
//        streamOfArray.map(s->s.split("")) //Преобразование слова в массив букв
//                .map(Arrays::stream).distinct() //Сделать массив в отдельный поток
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
        streamOfArray.forEach(System.out::println);

    }
}
