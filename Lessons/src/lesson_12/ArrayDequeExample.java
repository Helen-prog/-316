package lesson_12;

import java.util.ArrayDeque;

public class ArrayDequeExample {
    public static void main(String[] args) {
        ArrayDeque<String> states = new ArrayDeque<>();
        states.push("red");
        states.push("blue");
        states.push("white");
        states.push("green");
        states.push("black");
        System.out.println(states);

        System.out.println(states.getFirst());
        System.out.println(states.getLast());
        System.out.println(states.size());

        while(states.peek() != null) {
            System.out.println(states.pop());
        }
        System.out.println(states);
    }
}
