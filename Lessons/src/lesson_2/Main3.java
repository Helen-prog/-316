package lesson_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        try {
//            System.out.print("Введите первое число: ");
//            int a = sc.nextInt();
//            System.out.print("Введите второе число: ");
//            int b = sc.nextInt();
//            System.out.println(a / b);
//        } catch (InputMismatchException | ArithmeticException e) {
//            System.out.println("Вы ввели не целое число или делить на 0 нельзя");
//        } finally {
//            System.out.println("Конец программы");
//        }

//        try{
//            int[] numbers = new int[3];
//            numbers[4] = 9;
//        } catch(ArrayIndexOutOfBoundsException e){
//            System.out.println(e);
//            System.out.println("Введен некорректный индекс");
//        }

        int res = getFactorial(-5);
        System.out.println(res);
    }

    public static int getFactorial(int num) {
        int fact = 1;
        try {
            if (num < 1) {
                throw new Exception("Число меньше 1 указывать нельзя");
            }
            for (int i = 1; i <= num; i++) {
                fact *= i;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fact = num;
        }
        return fact;
    }
}
