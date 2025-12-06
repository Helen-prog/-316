package lesson_10;

interface CalcInterfaces{
    int calculate(int a, int b);
}

public class Sample {
    public static void main(String[] args) {
        CalcInterfaces sum = (a, b) -> a + b;
        CalcInterfaces sub = (a, b) -> a - b;
        CalcInterfaces mul = (a, b) -> a * b;

        int result = sum.calculate(3, 4);
        int result2 = sub.calculate(3, 4);
        int result3 = mul.calculate(3, 4);

        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
    }
}


