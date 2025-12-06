package lesson_8.generics;

import java.util.ArrayList;

public class Sample {
    public static void main(String[] args) {
        PrintList<Integer> pl = new PrintList<Integer>();
        for (int i = 0; i < 10; i++) {
            pl.add(i);
        }
        pl.printList(false);
    }
}

class PrintList<T>{
    private ArrayList<T> list;

    public PrintList() {
        this.list = new ArrayList<>();
    }

    public void add(T data) {
        list.add(data);
    }

    public void printList(boolean isOdd) {
        if (isOdd) {
            for (int i = 1; i < list.size(); i += 2) {
                System.out.print(list.get(i) + " ");
            }
        } else{
            for (int i = 0; i < list.size(); i += 2) {
                System.out.print(list.get(i) + " ");
            }
        }
    }
}
