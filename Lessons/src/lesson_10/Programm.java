package lesson_10;

interface Converter<F, T>{
    T convert(F from);
}

public class Programm {
    public static void main(String[] args) {
//        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Converter<String, Integer> converter = Integer::valueOf;
        Integer i = converter.convert("123");
        System.out.println(i);
    }
}
