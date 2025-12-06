package lesson_9;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;

        try {
            a = getNumber("Введите первое число");
            b = getNumber("Введите первое число");
        } catch (NumberFormatException e) {
            System.out.println("Значение некорректно");
        }

        System.out.println("Результат: " + (a + b));
    }

    public static int getNumber(String message) throws NumberFormatException {
        Scanner sc = new Scanner(System.in);
        System.out.print(message + ": ");
        String s = sc.nextLine();

        return Integer.parseInt(s);
    }
}
