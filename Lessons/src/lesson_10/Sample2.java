package lesson_10;

interface Printable {
    void print();
}

public class Sample2 {
    public static void main(String[] args) {
        Printable p = () -> System.out.println("Hello");
        p.print();
    }
}
