package oleg;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HelloWorld {
    private final static int INT1 = 050;

<<<<<<< HEAD
    public enum SmtnConst {INT1}

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(HelloWorld.class.getName());
        StringBuilder j = new StringBuilder(" Addition");
        System.out.println(+INT1);
        System.out.println(j.append(" I \"like\" Java! ").toString());
=======
    public enum SmtnConst {i}
//   @Log4j
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(HelloWorld.class.getName());
        StringBuilder j = new StringBuilder(" Addition");
        logger.log(Level.WARNING," Пример работы {}",+i);
        System.out.println("I \"like\" Java! " + j);
>>>>>>> 747e70655d8ae41f65b8b274d34feeb4643c2fff
        boolean rt = true;
        System.out.println("I like Java! " + rt);

        String[] array = new String[5];
// Generic Collection
//        List list = new ArrayList();  // список объектов
        List<Integer> list = new ArrayList();
        List<String> list1 = new ArrayList();
        List<? extends Number> list2 = new ArrayList();

        list.add(INT1);
        list.add(34);


        String str11 = "str";
        str11.chars().forEach(System.out::println);
        int[] iArray =  new int[] {3121,123,5123,546};
        logger.log(Level.INFO," End write list of integer! {0}",iArray[2]);

        IntStream.of(120, 410, 85, 32, 314, 12)
                .filter(x -> x < 300)
                .map(x -> x + 11)
                .limit(3)
                .forEach(System.out::println);

        String str = Math.random() > 0.3 ? "I'm feeling lucky" : null;
        Stream.ofNullable(str).forEach(System.out::println);

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


    }
}
