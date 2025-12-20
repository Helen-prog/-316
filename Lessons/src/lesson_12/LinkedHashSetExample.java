package lesson_12;

import java.util.LinkedHashSet;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(7);
        linkedHashSet.add(3);
        linkedHashSet.add(1);
        linkedHashSet.add(4);
        linkedHashSet.add(9);
        System.out.println(linkedHashSet);
        linkedHashSet.remove(4);
        System.out.println(linkedHashSet);
        System.out.println(linkedHashSet.contains(3));
        System.out.println(linkedHashSet.contains(4));
        System.out.println(linkedHashSet.removeIf(x -> x > 5));
        System.out.println(linkedHashSet);
    }
}
