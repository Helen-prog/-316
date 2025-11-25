package lesson_3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Main3 {
    public static void main(String[] args) {
//        String s = "Я ищу совпадения в 2025 году. Я их найду в 2 счёта. 6789 Hello_World. Ели[-ели]";
//        String pattern = "[12][0-9][0-9][0-9]";
//        String pattern = "[А-яЁёA-Za-z]";
//        String pattern = "\\.";
//        String pattern = "[._]";
//        String pattern = "[^0-9]";
//        String pattern = "[А-я.\\]\\[-]";

//        String s = "21:45 00 23";
//        String pattern = "[0-2][0-9]:[0-5][0-9]";
//        Pattern regex = Pattern.compile(pattern);
//        Matcher matcher = regex.matcher(s);
//
//        while (matcher.find()){
////            System.out.println(s.substring(matcher.start(), matcher.end()));
//            System.out.println(matcher.group());
//        }

        try {
//            String s = "Я ищу совпадения в 2025 году. Я их найду в 2 счёта. 6789 Hello_World. Ели[-ели] 2000000";
//            String s = "Цифры: 7, +17, -42, 0013, 0.3";
//            String pattern = "[+-]?\\d+\\.?\\d*";
//            String pattern = "[+-]?[\\d.]+";
 //           String s = "author=Пушкин А.С.; title  = Евгений Онегин; price =200; year= 1831";
//            String pattern = "\\w+\\s*=\\s*[А-я0-9 .]*";
 //           String pattern = "\\w+\\s*=[^;]+";
//            String s = "12 сентября 2024 года 456";
//            String pattern = "\\d{2,4}";  // {4}, {2,}, {2,4}
//            String s = "I learning Java";
//            String s = "Java_master";
//            String pattern = "^[\\w-]{3,16}$";
//            String s = "Я ищу совпадения в 2025 году. Я их найду в 2 счёта. 6789 Hello_WorldL. Ели[-ели] 2000000";
//            String pattern = "я";
//            Pattern regex = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
//            String s = "one\ntwo";
//            String pattern = "one$";
//            String s = "Java,\njava,\nJAVA";
//            String pattern = "(?im)^java";
//            String s = "<body>Пример жадного соответствия</body>";
//            String pattern = "<.*?>";
//            String s = "12 сентября 2024 года 456";
//            String pattern = "\\d{2,}?";  // {4}, {2,}, {2,4}
//            String s = "Word2016, PS6, AI5";
//            String pattern = "([A-Za-z]+)(\\d+)";
//            String s = "Ольга и Виталий отлично учатся";
//            String pattern = "Петр|Ольга|Виталий";
//            String s = "int = 4, float = 4.0f, double = 8.0";
//            String pattern = "(int|float)\\s*=\\s*(\\d[.\\w]*)";
            String s = "25-11-2025";
            String pattern = "(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(19[0-9][0-9]|20[0-9][0-9])";
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(s);
            while (matcher.find()) {
                System.out.println(matcher.group() + " ");
//                System.out.println(matcher.group(1) + " ");
//                System.out.println(matcher.group(2) + " ");
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Неправильное регулярное выражение: " + e.getMessage());
            System.out.println("Описание: " + e.getDescription());
            System.out.println("Позиция: " + e.getIndex());
            System.out.println("Неправильный шаблон: " + e.getPattern());
        }
    }
}
