package lesson_4;

public class Main2 {
    public static void main(String[] args) {
        Calculation cal = new Calculation();
        // По количеству параметров
        cal.calculate(1, 2);
        cal.calculate(1, 2, 3);

        // По типу параметров
        cal.calculate(2.5, 3.4);

        // По порядку параметров
        cal.calculate(2.5, 2);
        cal.calculate( 2,2.5);
    }
}

class Calculation{
    public void calculate(int a, int b){
        System.out.println(STR."Сумма двух чисел: \{a + b}");
    }
    public void calculate(int a, int b, int c){
        System.out.println(STR."Сумма трех чисел: \{a + b + c}");
    }

    public void calculate(double a, double b){
        System.out.println(STR."Сумма двух вещественных чисел: \{a + b}");
    }

    public void calculate(double a, int b){
        System.out.println(STR."В результате вещественное чисел: \{a + b}");
    }
    public void calculate(int a, double b){
        System.out.println(STR."В результате целое чисел: \{(int) (a + b)}");
    }
}
