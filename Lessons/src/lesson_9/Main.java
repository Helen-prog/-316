package lesson_9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        String first = sc.nextLine();

        System.out.print("Введите второе число: ");
        String second = sc.nextLine();

        int a = 0;
        int b = 0;

        try {
            a = Integer.parseInt(first);
            b = Integer.parseInt(second);
        } catch (NumberFormatException e) {
            System.out.println("Одно или оба значения некорректны");
        }

        System.out.println("Результат: " + (a+b));
    }
}
