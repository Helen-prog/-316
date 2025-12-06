package lesson_10;

public class Test {
    public static void main(String[] args) {
        int x = 5, y = 3;
        CalcInterface sum = new Calc1();
        sum.calculate(x, y);  // 8

        CalcInterface sum1 = new CalcInterface() {
            @Override
            public void calculate(int a, int b) {
                System.out.println(a * b);
            }
        };
        sum1.calculate(x, y); // 15

        CalcInterface sum2 = (a, b) -> System.out.println(a * b);
        sum2.calculate(x, y);
    }
}

interface CalcInterface{
    public void calculate(int a, int b);
}

class Calc1 implements CalcInterface{

    @Override
    public void calculate(int a, int b) {
        System.out.println(a + b);
    }
}
