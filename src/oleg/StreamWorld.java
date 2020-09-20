package oleg;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamWorld {
    public static void main(String[] args) {

/*
        IntStream.of(120, 410, 85, 32, 314, 12)
                .filter(x -> x < 300)
                .map(x -> x + 11)
                .limit(3)
                .forEach(System.out::println);

        String str = Math.random() > 0.3 ? "I'm feeling lucky" : null;
        Stream.ofNullable(str)
                .forEach(System.out::println);

        Stream.generate(() -> 6)
                .limit(6)
                .forEach(System.out::print);

        Stream.iterate(2, x -> x + 6)
              .limit(6)
              .forEach(System.out::println);

        Stream.Builder<Integer> streamBuider = Stream.<Integer>builder()
            .add(0)
            .add(1);
            for(int i1 = 2;i1 <=6;i1 +=2){
                streamBuider.accept(i1);
            }
            streamBuider.add(9)
            .add(10)
            .build()
            .forEach(System.out::println);

        IntStream.range(0, 5)
                .forEach(System.out::println);
        LongStream.range(-10L, -5L)
                .forEach(System.out::println);
        IntStream.range(2, 9)
                .filter(x -> x % 3 == 0)
                .forEach(System.out::println);
        Stream.of(0, 3, 0, 0, 5)
                .peek(x -> System.out.format("before distinct: %d%n", x))
                .distinct()
                .peek(x -> System.out.format("after distinct: %d%n", x))
                .map(x -> x * x)
                .forEach(x -> System.out.format("after map: %d%n", x));
        IntStream.range(0, 10)
                .skip(4)
                .limit(3)
                .skip(2)
                .forEach(System.out::println);
        Stream.of(120, 410, 85, 32, 314, 12)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        Stream.of(120, 410, 85, 32, 314, 12)
                .forEach(x -> System.out.format("%s, ", x));
        String s = Stream.of(1, 2, 3)
                .map(String::valueOf)
                .collect(Collectors.joining("-","<",  ">"));

        int product = IntStream.range(0, 10)
                .filter(x -> x++ % 4 == 0)
                .reduce((acc, x) -> acc * x)
                .getAsInt();
                ;
        */

        Map<Character, String> map3 = Stream.of(50, 54, 55)
                .collect(Collectors.toMap(
                        i -> (char) i.intValue(),
                        i -> String.format("<%d>", i)
                ));
        System.out.println(map3);
    }
}
