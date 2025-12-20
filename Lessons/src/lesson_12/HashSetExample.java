package lesson_12;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
//        Set<String> set = new HashSet<String>();
//        set.add("Валентин");
//        set.add("Николай");
//        set.add("Григорий");
//        set.add("Александр");
//        set.add("Александр");
//        System.out.println(set);
////        set.remove("Александр");
//        set.add(null);
//        for (String s : set) {
//            System.out.println(s);
//        }
//        System.out.println(set.size());
////        System.out.println(set.contains("Александр"));

//        Set<Integer> a = new HashSet<>();
//        Set<Integer> b = new HashSet<>();
//
//        a.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
//        b.addAll(Arrays.asList(5, 6, 7, 8, 9));
//
//        System.out.println(a);
//        System.out.println(b);
//
//        HashSet<Integer> c = new HashSet<>(a);
//        System.out.println(c);
//        c.addAll(b);  // объединение
//        System.out.println(c);
//
//        HashSet<Integer> d = new HashSet<>(a);
//        System.out.println(d);
//        d.retainAll(b);  // пересечение
//        System.out.println(d);
//
//        HashSet<Integer> e = new HashSet<>(a);
//        System.out.println(e);
//        e.removeAll(b);  // разность
//        System.out.println(e);

//        Set<Integer> num = new HashSet<>();
//        num.add(54);
//        num.add(21);
//        num.add(24);
//        num.add(31);
//        num.add(43);
//        System.out.println(num);
//
//        Integer max = null;
//
//        for (Integer i : num) {
//            if(max == null){
//                max = i;
//            } else if(max < i) {
//                max = i;
//            }
//        }
//        System.out.println(max);
//
//        System.out.println(Collections.min(num));

        int[] arr = {2, 5, 2, 7, 8, 8, 10};
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
//        System.out.println(set);
        int[] uniqueArr = new int[set.size()];
        int index = 0;
        for (Integer i : set) {
            uniqueArr[index++] = i;
        }
        System.out.println("Массив без дубликатов: " + Arrays.toString(uniqueArr));
    }
}
