package com.itacademy.firstgit;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Description of this lesson from 18/09/2020
 *
 * @author Oleg Vydra
 */
public class MainLesson5 {
    public static void main(String[] args) {

        Collection<String> collection = Arrays.asList("a1", "a2", "a2");
        collection.stream().forEach(System.out::println);

        int[] array = new int[10];
//        Arrays.stream(array).forEach(System.out::println);
//        Stream<String> streamFromFiles = Files.lines(Paths.get("file.txt"))   ;
//Stream.iterate()
//        Stream.generate()
//        Stream<String> stream = stream(array);
        Stream.of("140","23","200","234")
                .map((Integer::parseInt))
                .map(x-> x+10)
//                .flatMap(x->IntStream.range())
                .filter(x->x>50)
                .forEach(System.out::println);
/*
        IntStream.range(2,10)
//                .takeWhile(x-> x!=5)
                .dropWhile(y-> y > 4)
                .distinct()
//                .boxed()
                .forEach(System.out::println);
*/

        IntStream.of(23,34,45,65,65,1,234,5)
                .forEachOrdered(System.out::println);

        System.out.println(IntStream.range(5,10000)
                .parallel()
//                .findAny()
                .findFirst()
                .getAsInt()
        );
    }
}
