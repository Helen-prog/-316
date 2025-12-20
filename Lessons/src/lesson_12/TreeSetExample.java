package lesson_12;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
//        Set<Integer> treeSet = new TreeSet<Integer>();
//        treeSet.add(5);
//        treeSet.add(1);
//        treeSet.add(8);
//        treeSet.add(3);
//        treeSet.add(7);
//        System.out.println(treeSet);
//        treeSet.remove(3);
//        System.out.println(treeSet);
//        System.out.println(treeSet.contains(5));
//        System.out.println(treeSet.contains(2));

        TreeSet<Student2> ts = new TreeSet<>();
        Student2 st1 = new Student2("Виктор", 5);
        Student2 st2 = new Student2("Герман", 3);
        Student2 st3 = new Student2("Ольга", 1);
        Student2 st4 = new Student2("Ирина", 4);
        Student2 st5 = new Student2("Михаил", 2);
        ts.add(st1);
        ts.add(st2);
        ts.add(st3);
        ts.add(st4);
        ts.add(st5);
        System.out.println(ts);
        System.out.println(ts.first());
        System.out.println(ts.last());
        Student2 st6 = new Student2("Алена", 3);
        System.out.println(ts.headSet(st6));
        System.out.println(ts.tailSet(st6));
        Student2 st7 = new Student2("Игорь", 2);
        Student2 st8 = new Student2("Владимр", 4);
        System.out.println(ts.subSet(st7, st8));

        Iterator<Student2> it = ts.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("=================================");
        Iterator<Student2> it2 = ts.descendingIterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }
    }
}

class Student2 implements Comparable<Student2> {
    String name;
    int curse;

    public Student2(String name, int curse) {
        this.name = name;
        this.curse = curse;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", curse=" + curse +
                '}';
    }

    @Override
    public int compareTo(Student2 o) {
        return curse - o.curse;
    }
}
