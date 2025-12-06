package lesson_10;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Sample8 {
    public static void main(String[] args) {
//        Predicate<Integer> isPositive = x -> x > 0;
//        System.out.println(isPositive.test(5));
//        System.out.println(isPositive.test(-7));

//        Predicate<String> isPalindrome = str -> {
//            String s = new StringBuilder(str).reverse().toString();
//            return str.equals(s);
//        };
//
//        System.out.println(isPalindrome.test("Мадам"));
//        System.out.println(isPalindrome.test("радар"));
//        System.out.println(isPalindrome.test("палиндром"));

//        Function<Integer, String> convert = x -> String.valueOf(x) + " долларов";
//        System.out.println(convert.apply(10));

//        Function<Double, Long> function = d -> Math.round(d);
//        System.out.println(function.apply(3.14));

//        String t = "One";
//        Supplier<String> s = () -> t.toUpperCase();
//        System.out.println(s.get());

        Consumer<Integer> printer = x -> System.out.printf("%d долларов%n", x);
        printer.accept(700);
    }
}
