package lesson_12;

//import java.util.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("Валерий");
//        arrayList.add("Ирина");
//        arrayList.add("Игорь");
//        System.out.println(arrayList);
//        System.out.println(arrayList.size());
//
//
//        ArrayList<String> arrayList1 = new ArrayList<>(arrayList);
//        arrayList1.add("Владимир");
//        System.out.println(arrayList1);
//
//        System.out.println(arrayList);
//
//        ArrayList arrayList2 = new ArrayList();
//        arrayList2.add("Наталья");
//        arrayList2.add(7);
//        arrayList2.add(true);
//        System.out.println(arrayList2);
//
//        ArrayList<String> arrayList3 = new ArrayList<>();
//        arrayList3.add("!!!");
//        arrayList3.add("???");
//        arrayList3.addAll(1, arrayList);
//        arrayList3.add(2,"%%%");
//        System.out.println(arrayList3);
//////        arrayList3.removeAll(arrayList);
//////        arrayList3.retainAll(arrayList);
////        List<String> myList = arrayList3.subList(0, 3);
////        System.out.println(myList);
////        myList.add("Борис");
////        System.out.println(myList);
////        System.out.println(arrayList3);
////
////        String[] array = arrayList3.toArray(new String[2]);
////        for(String s : array) {
////            System.out.print(s + " ");
////        }
////        System.out.println("\n" + array.length);
//
////        Collections.sort(arrayList3);
////        Collections.shuffle(arrayList3);
////        Collections.reverse(arrayList3);
////        Collections.swap(arrayList3, 0, 2);
////        System.out.println(arrayList3);
//
//        // Итератор
//        Iterator<String> iterator = arrayList3.iterator();
//        while (iterator.hasNext()) {
//            iterator.next();
//            iterator.remove();
//        }
//        System.out.println(arrayList3);
        Student st1 = new Student("Viktor", 2);
        Student st2 = new Student("Anna", 3);
        Student st3 = new Student("Irina", 1);
        Student st4 = new Student("Igor", 3);
        Student st5 = new Student("Roman", 2);
        LinkedList<Student> list = new LinkedList<>();
        list.add(st1);
        list.add(st2);
        list.add(st3);
        list.add(st4);
        list.add(st5);
        System.out.println(list);
        System.out.println(list.get(2));
        Student st6 = new Student("Maria", 2);
        Student st7 = new Student("Sergey", 1);
//        list.add(1, st6);
//        list.add(st7);
//        list.addFirst(st6);
//        list.addLast(st7);
//        list.set(1, st7);
//        list.remove(3);
//        list.removeFirst();
//        list.removeLast();
        System.out.println(list);
//        for(Student s : list){
//            System.out.println(s);
//        }
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("Элемент по индексу " + i + ": " + list.get(i));
//        }

//        Iterator p = list.listIterator(3);
//        while (p.hasNext()) {
//            System.out.println(p.next());
//        }

//        Iterator iterator = list.descendingIterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

//        Object first = list.getFirst();
//        System.out.println(first);
//        Object last = list.getLast();
//        System.out.println(last);
////        list.clear();
//        System.out.println(list);
//        System.out.println("Пустой список? " + list.isEmpty());

        ListIterator<Student> listIterator = list.listIterator();
        System.out.println("Итератор прямого порядка:");
        while (listIterator.hasNext()) {
            System.out.println("Index = " + listIterator.nextIndex() + ", Element = " + listIterator.next());
        }

        System.out.println("Итерация в обратном направлении");
        while (listIterator.hasPrevious()) {
            System.out.println("Index = " + listIterator.previousIndex() + ", Element = " + listIterator.previous());
        }
    }
}

class Student{
    String name;
    int course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }
}
