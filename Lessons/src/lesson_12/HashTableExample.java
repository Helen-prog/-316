package lesson_12;

import java.util.Hashtable;

public class HashTableExample {
    public static void main(String[] args) {
        Hashtable<Integer, String> ht1 = new Hashtable<>();
        ht1.put(1, "one");
        ht1.put(2, "two");
        ht1.put(3, "three");

        Hashtable<Integer, String> ht2 = new Hashtable<>(ht1);
        ht2.put(4, "four");
        ht2.put(5, "five");
//        ht2.put(6, "six");

        System.out.println("ht1: " + ht1);
        System.out.println("ht2: " + ht2);
    }
}
