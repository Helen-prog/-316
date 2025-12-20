package lesson_12;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(334455, "Михаил Борисов");
        map.put(778899, "Ринат Зуев");
        map.put(4433666, "Роман Свиридов");
        map.put(225577, "Анна Полякова");
        map.put(884466, "Анна Полякова");
//        map.put(null, "Ирина Мельнийчук");
//        map.put(225544, null);
        map.putIfAbsent(334455, "Вадим Рогов");
        System.out.println(map);
//        System.out.println(map.get(334455));
//        System.out.println(map.get(222222));
        map.remove(334455);
        System.out.println(map);
        System.out.println(map.containsValue("Ринат Зуев"));
        System.out.println(map.containsKey(4433666));

        System.out.println(map.keySet());
        System.out.println(map.values());
    }
}
