package lesson_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Sample {
    public static void main(String[] args) {
//        Stream<String> people1 = Stream.of("Виктор", "Екатерина", "Дмитрий");
//        Stream<String> people2 = Stream.of("Александр", "Виктория", "Дмитрий");
//        Stream.concat(people1, people2).distinct().forEach(System.out::println);

        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(7, 8, 9, 10, 1, 2, 3, 4, 5, 6));
        System.out.println(list.stream().max(Integer::compareTo).get());
        System.out.println(list.stream().min(Integer::compareTo).get());
    }
}
