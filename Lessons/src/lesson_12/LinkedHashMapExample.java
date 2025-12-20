package lesson_12;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put(1, "obj1");
        linkedHashMap.put(15, "obj15");
        linkedHashMap.put(4, "obj4");
        linkedHashMap.put(38, "obj38");
        System.out.println(linkedHashMap);
        System.out.println(linkedHashMap.get(1));
        System.out.println(linkedHashMap.get(4));
        System.out.println(linkedHashMap);
        for (Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
