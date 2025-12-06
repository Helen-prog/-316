package lesson_10;

interface Calc3<T>{
   T calculate(T x, T y);
}

public class Sample4 {
    public static void main(String[] args) {
        Calc3<Integer> operation1 = (x, y) -> x + y;
        Calc3<String> operation2 = (x, y) -> x + y;
        System.out.println(operation1.calculate(2, 3));
        System.out.println(operation2.calculate("Hello", "World"));
    }
}
