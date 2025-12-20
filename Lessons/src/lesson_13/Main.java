package lesson_13;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        Stream<String> citiesStream = Arrays.stream(new String[]{"Сочи", "Москва", "Калининград"});
////        citiesStream.forEach(System.out::println);
//        citiesStream.forEach(s -> System.out.print(s + " "));
//        System.out.println();
//        IntStream intStream = Arrays.stream(new int[]{1, 2, 3, 4, 5});
//        intStream.forEach(s -> System.out.print(s + " "));
//        System.out.println();
//
//        Stream<String> cs = Stream.of("Сочи", "Москва", "Калининград");
//        cs.forEach(s -> System.out.print(s + " "));
//        System.out.println();
//
//        String[] cities = {"Сочи", "Москва", "Калининград"};
//        Stream<String> cs2 = Stream.of(cities);
//        cs2.forEach(s -> System.out.print(s + " "));
//        System.out.println();
//
//        IntStream intStream2 = IntStream.of(1, 2, 3, 4, 5);
//        intStream2.forEach(s -> System.out.print(s + " "));

//        String[] arguments = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
//        Map<String, String> argsMap = new LinkedHashMap<>(arguments.length / 2);
//        for (int i = 0; i < arguments.length; i += 2) {
//            argsMap.put(arguments[i], arguments[i + 1]);
//        }
//        argsMap.forEach((k, v) -> System.out.println(k + "=" + v));

//        Stream<String> cs = Stream.of("Сочи", "Москва", "Калининград");
//        cs.filter(s -> s.length() >= 6).forEach(System.out::println);

//        int[] numbers = {-5, 0, 1, 2, 3, -4, 4, -3, -2, -1, 5};
//        int count = 0;
//        for (int i : numbers)
//            if (i > 0) count++;
//        System.out.println(count);
//
////        long cnt = IntStream.of(-5, 0, 1, 2, 3, -4, 4, -3, -2, -1, 5).filter(i -> i > 0).count();
//        long cnt = IntStream.of(numbers).filter(i -> i > 0).count();
//        System.out.println(cnt);
//        List<String> colors = Arrays.asList("Красный", "Кремовый", "Синий", "Зеленый", "Коричневый");
//        System.out.println(colors);
//        long ctr = colors.stream()
//                .filter(s -> s.startsWith(String.valueOf('К'))).count();
//        System.out.println("Количество цветов, которые начинаются с 'K': " + ctr);
//        ctr = colors.stream()
//                .filter(s -> s.startsWith(String.valueOf('З'))).count();
//        System.out.println("Количество цветов, которые начинаются с 'З': " + ctr);

        Stream<Notebook> notebooks = Stream.of(
          new Notebook("ThinkPad", 40000),
          new Notebook("MacBook", 45000),
          new Notebook("Legion", 55000)
        );

        // notebooks.filter(p -> p.getPrice() < 50000).forEach(p -> System.out.println(p.getName()));
//        notebooks.map(p -> p.getName()).forEach(System.out::println);
       // notebooks.map(p -> "название: " + p.getName() + ", цена: " + p.getPrice()).forEach(System.out::println);
       // notebooks.flatMap(p -> Stream.of("название: " + p.getName() + ", цена без скидки: " + p.getPrice(),
//                "название: " + p.getName() + ", цена со скидкой: " + (p.getPrice() - (int) (p.getPrice() * 0.1))))
//                .forEach(System.out::println);

        notebooks.sorted(new NotebookComparator()).forEach(p -> System.out.printf("%s - %d \n", p.getName(), p.getPrice()));
    }
}

class Notebook{
    private String name;
    private int price;

    public Notebook(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

class NotebookComparator implements Comparator<Notebook> {

    @Override
    public int compare(Notebook o1, Notebook o2) {
        return o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
    }
}
