package lesson_12;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        pq.add(5);
//        pq.add(1);
//        pq.add(9);
//        pq.add(2);
//        pq.add(3);
//        pq.add(3);
//        System.out.println(pq);
//
////        while (!pq.isEmpty()) {
////            System.out.println(pq.remove());  // poll()
////        }
////        System.out.println(pq);
////        System.out.println(pq.poll());
//        System.out.println(pq.element());  // peek()

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(Comparator.comparing(String::length));
        priorityQueue.add("Александр");
        priorityQueue.add("Игорь");
        priorityQueue.add("Андрей");

        System.out.println(priorityQueue);
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.remove());
        }
    }
}
