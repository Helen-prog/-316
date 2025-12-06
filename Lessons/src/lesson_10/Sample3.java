package lesson_10;

interface Calc2{
    int calculate();
}

public class Sample3 {
//    static int x = 10;
//    static int y = 20;

    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        Calc2 operation = () -> {
            return x + y;
        };
//        x = 30;

        System.out.println(x);
        System.out.println(operation.calculate());
    }
}
