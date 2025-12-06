package lesson_11.collection;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;

public class Program {
    public static void main(String[] args) {
        University un1 = new University("Университет", 300);
        University un2 = new University("Начальная школа", 150);
        University un3 = new University("Средняя школа", 357);
        University un4 = new University("Высшая школа", 246);
        University un5 = new University("Музыкальная школа", 789);
        SortUniversity sortUniversity = new SortUniversity();
        int res = sortUniversity.compare(un1, un2);
        switch (res) {
            case -1:
                System.out.println(un2.getName() + " больше!");
                break;
            case 1:
                System.out.println(un1.getName() + " больше!");
                break;
            default:
                System.out.println("Два учебных заведения одинаковые!");
        }

        ArrayList<University> list = new ArrayList<University>();
        list.add(un1);
        list.add(un2);
        list.add(un3);
        list.add(un4);
        list.add(un5);

        System.out.println("\nСортировка по имени:");
        SortNameUniversity nameCompare = new SortNameUniversity();
        Collections.sort(list, nameCompare);
        for (University un : list) {
            System.out.println(un.getName() + " " + un.getNumOfStudents());
        }

        System.out.println("\nСортировка по количеству участников:");
        SortUniversity countCompare = new SortUniversity();
        Collections.sort(list, countCompare);
        for (University un : list) {
            System.out.println(un.getName() + " " + un.getNumOfStudents());
        }
    }
}

class University{
    private int numOfStudents;
    private String name;

    public University(String name, int numOfStudents) {
        this.name = name;
        this.numOfStudents = numOfStudents;
    }

    public int getNumOfStudents() {
        return numOfStudents;
    }

    public String getName() {
        return name;
    }
}

class SortUniversity implements Comparator<University> {
    @Override
    public int compare(University o1, University o2) {
        if (o1.getNumOfStudents() == o2.getNumOfStudents()) {
            return 0;
        }else{
            return o1.getNumOfStudents() > o2.getNumOfStudents() ? 1 : -1;
        }

    }
}

class SortNameUniversity implements Comparator<University> {

    @Override
    public int compare(University o1, University o2) {
        return o1.getName().compareTo(o2.getName());
    }
}