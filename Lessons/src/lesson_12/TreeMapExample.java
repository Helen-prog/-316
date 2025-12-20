package lesson_12;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
//        TreeMap<String, String> map = new TreeMap<>();
        TreeMap<String, String> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
//        TreeMap<String, String> map = new TreeMap<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.compareTo(o1);
//            }
//        });
        map.put("Python", "*.py");
        map.put("C++", "*.cpp");
        map.put("JavaScript", "*.js");
        map.put("Golang", "*.go");
        map.put("Java", "*.java");
        map.put("java", "*.java");

        System.out.println(map);
//        System.out.println(map.get("Python"));
//        map.remove("Golang");
//        System.out.println(map);
////        System.out.println(map.descendingMap());
//        System.out.println(map.firstEntry());
//        System.out.println(map.lastEntry());
    }
}
