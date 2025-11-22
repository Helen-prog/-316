package lesson_1;

import java.util.Scanner;
import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int i = 0;
//        while (i < 10) {
//            System.out.println("i = " + i);
//            i++;
//        }

//        int n, sum = 0;
//        System.out.print("¬ведите число: ");
//        while (sc.hasNextInt()) {
//            System.out.print("¬ведите число: ");
//            n = sc.nextInt();
//            sum += n;
//        }
//        System.out.println("—умма введенных чисел: " + sum);

//        int i = 0;
//        do{
//            System.out.println("i = " + i);
//            i++;
//        } while (i < 5);

//        int number, copy, reverse_number = 0;
//        System.out.print("¬ведите число: ");
//        number = sc.nextInt();   // 321
//        copy = number;  // 321
//        do{
//            reverse_number *= 10;
//            reverse_number += copy % 10;
//            copy /= 10;
//        } while (copy > 0);
//        System.out.println("„исло " + number + (number == reverse_number ? " " : " не ") + "палиндром");


//        int i = 0;
//        do {
//            if(i==3){
//                i++;
//                continue;
//            }
//            System.out.println("i = " + i);
//            if(i == 5) break;
//            i++;
//        } while (i < 10);

//        int i = 1;
//        while (i < 10) {
//            int j = 1;
//            while (j < 10) {
//                System.out.print(i + " * " + j + " = " + i * j + "\t\t");
//                j++;
//            }
//            System.out.println();
//            i++;
//        }

//        int i = 0;
//        while (i < 5) {
//            int j = 0;
//            while (j < 16) {
//                if(i % 2 == 0)
//                    System.out.print("+");
//                else
//                    System.out.print("-");
//                j++;
//            }
//            System.out.println();
//            i++;
//        }
//        int count = 0;
//        for (int i = 0; i < 6; i++) {
//            System.out.print("-> ");
//            if(sc.hasNextInt()) {
//                count++;
//            }
//            sc.nextLine();
//        }
//        System.out.println("¬ы ввели чисел: " + count);
//        int i = 10;
//        for (; true; ) {
//            System.out.print(i + " ");
//            if(i == 90) break;
//            i += 10;
//        }
//        for (int i = 5, a = 0; i > 0; i--, a++) {
//            System.out.println("Ўаг: " + a + " «начение: " + i);
//        }

//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 16; j++) {
//                if(j == 0 || i == 0 || j == 15 || i == 3)
//                    System.out.print("*");
//                else
//                    System.out.print(" ");
//            }
//            System.out.println();
//        }

//        int mas[] = new int[4];
////        int[] mas2 = new int[5];
////        int mas3[];
////        mas3 = new int[4];
////        int mas[] = new int[]{2, 7, 5, 4};
//        mas[0] = 5;
//        mas[1] = 2;
//        mas[2] = 7;
//        mas[3] = mas[1] + mas[2];
////        System.out.println(mas[0]);
////        System.out.println(mas[1]);
////        System.out.println(mas[2]);
////        System.out.println(mas[3]);
////        System.out.println(mas.length);
////        int last = mas[mas.length - 1];
////        System.out.println(last);
//
//        for (int i = 0; i < mas.length; i++) {
//            System.out.println(mas[i]);
//        }

//        int n = 10;
//        int mas[] = new int[n];
////        System.out.println(mas.length);
//        mas[n - 1] = 2;
//        mas[n - 2] = 3;
//        mas[n / 5] = mas[n - 1] + mas[n - 2];
//        for (int i = 0; i < mas.length; i++) {
//            System.out.println(mas[i]);
//        }

//        int[] array = new int[4];
//        System.out.print("-> ");
//        array[0] = sc.nextInt();
//        System.out.print("-> ");
//        array[1] = sc.nextInt();
//        System.out.print("-> ");
//        array[2] = sc.nextInt();
//        System.out.print("-> ");
//        array[3] = sc.nextInt();
//        for (int i = 0; i < array.length; i++) {
//            System.out.print("-> ");
//            array[i] = sc.nextInt();
//        }
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
//        System.out.println("\n" + Arrays.toString(array));

//        System.out.print("¬ведите количество элементов массива: ");
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            System.out.print("-> ");
//            arr[i] = sc.nextInt();
//        }
//        System.out.println(Arrays.toString(arr));
//
//        for (int i = 1; i < n; i++) {
//            if(arr[i] > arr[i-1]) {
//                System.out.print(arr[i] + " ");
//            }
//        }

//        int[] a1 = new int[]{1, 2, 3, 4};
//        int[] a1 = {1, 2, 3, 4};
//        int[] a2 = new int[a1.length + 5];
//        for (int i = 0; i < a1.length; i++) {
//            a2[i] = a1[i];
//        }
//        for (int i = 0; i < a2.length; i++) {
//            System.out.println(a2[i]);
//        }

        // (Math.random() * (max-min)) + min
        // (5 - (-5)) + (-5)
//        double a = Math.random() * 3;  // от 0 до 3
//        double a = Math.random() * 5 + 2;  // от 2 до 7
//        double a = 2 + Math.random() * 5 ;  // от 2 до 7
//        double a = Math.random() * 10 - 5;  // от -5 до 5
//        int a = (int) (Math.random() * 3) + 1;  // от 1 по 3
//        int a = 3 + (int) (Math.random() * 2);  // от 3 до 5
//        int a = (int) (Math.random() * 2 + 3);  // от 3 до 5
//        System.out.println(a);

//        int[] array = new int[20];
//        for (int i = 0; i < array.length; i++) {
////            array[i] = (int)(Math.random() * 12 + 2);  // от 2 до 14
//            array[i] = (int)(Math.random() * 31 - 15);  // от -15 до 16
//        }
//        System.out.println(Arrays.toString(array));

//        int[] numbers = {10, 20, 30, 40, 50};
//        for (int i = 0; i < numbers.length; i++) {
//            System.out.print(numbers[i] + " ");
//        }
//        System.out.println();
//        for (int x : numbers) {
//            System.out.print(x + " ");
//        }

        String [] cities = {"Ѕр€нск", "»ркутск", "¬ладивосток", "јрмавир"};
        System.out.println(Arrays.toString(cities));
        String [] cities2 = new String[cities.length + 1];
        for (int i = 0; i < cities.length; i++) {
            cities2[i] = cities[i];
        }
        cities2[cities.length] = " расно€рск";
        System.out.println(Arrays.toString(cities2));
    }
}
