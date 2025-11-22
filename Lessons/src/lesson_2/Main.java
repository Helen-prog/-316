package lesson_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        ArrayList <String> cities = new ArrayList <>();  // {"Брянск", "Иркутск", "Владивосток", "Армавир"};
//        System.out.println(cities.size());
//        cities.add("Брянск");
//        cities.add("Иркутск");
//        cities.add("Владивосток");
//        cities.add("Армавир");
//        cities.add(1, "Красноярск");
//        System.out.println(cities);
//        System.out.println(cities.get(2));
//        System.out.println(cities.size());
//
//        cities.set(2, "Курск");
//
//        for(String city : cities){
//            System.out.print(city + "\t");
//        }
//
//        System.out.println("\n" + cities.indexOf("Владивосток"));
//
//        if(cities.contains("Курск")){
//            System.out.println("ArrayList содержит Курск");
//        }
//
//        cities.remove(1);
//        cities.remove("Владивосток");
//        System.out.println(cities);
//
//        for(int i = 0; i < cities.size(); i++){
//            System.out.print(cities.get(i) + "\t");
//        }

//        int n, k;
//        ArrayList<Integer> mas = new ArrayList<>();
//        System.out.println("Введите элементы списка: ");
//        while ((n = sc.nextInt()) > 0) {
//            mas.add(n);
//        }
//        System.out.print("Введите индекс: ");
//        k = sc.nextInt();
//        mas.remove(k);
//        System.out.println(mas);

//        ArrayList<Integer> array = new ArrayList<>();
//
//        Random rand = new Random();
//
//        for (int i = 0; i < 10; i++) {
//            // array.add(rand.nextInt(100));
//            array.add((int) (Math.random() * 100));
//        }
//
//        System.out.println(array);
//
//        int max = array.get(0);
//
//        for (Integer elem : array) {
//            if (elem > max) {
//                max = elem;
//            }
//            ;
//        }
//
//        System.out.println("Max: " + max);
//
//        int index = array.indexOf(max);
//        array.remove(index);
//        array.add(0, max);
//
//        System.out.println(array);
//
//        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
//        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(11, 22, 33, 44, 45));
//        ArrayList<Integer> c = new ArrayList<>();
//
//        for (int i=0; i<a.size(); i++) {
//            c.add(a.get(i));
//            c.add(b.get(i));
//        }
//
//        for (int i = a.size(); i < b.size(); i++) {
//            c.add(b.get(i));
//        }
//
//        System.out.println(c);

//        int[][] numbers = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}};
//        System.out.println(numbers[1][3]);
//        for (int i = 0; i < numbers.length; i++) {
//            System.out.println(Arrays.toString(numbers[i]));
//        }
//
//        for (int i = 0; i < numbers.length; i++) {
//            for (int j = 0; j < numbers[i].length; j++) {
//                System.out.print(numbers[i][j] + "\t");
//            }
//            System.out.println();
//        }

//        int n = 5;
//        char[][] graph = new char[n][n];
//        for (int i = 0; i < graph.length; i++) {
//            System.out.println(Arrays.toString(graph[i]));
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                graph[i][j] = '*';
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }

//        int sum = Integer.MAX_VALUE;
//        int tmp = 0, n = 0;
//        int arr[][] = new int[3][5];
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                arr[i][j] = (int) (Math.random() * 100);
//                System.out.print(arr[i][j] + "\t\t");
//            }
//            System.out.println();
//        }
//        System.out.println();
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                tmp += arr[i][j];
//            }
//            if(sum > tmp){
//                sum = tmp;
//                n = i;
//            }
//            System.out.println("Сумма элементов " + (i + 1) + " строки: " + tmp);
//            tmp = 0;
//        }
//        System.out.println("\nСтрока с минимальной суммой элементов " + sum + ", имеет номер " + (n + 1));

//        int[][] mas = new int[3][];
//        mas[0] = new int[2];
//        mas[1] = new int[3];
//        mas[2] = new int[4];
//
//        for (int i = 0; i < mas.length; i++) {
//            for (int j = 0; j < mas[i].length; j++) {
//                mas[i][j] = sc.nextInt();
//            }
//        }
//
//        for (int i = 0; i < mas.length; i++) {
//            for (int j = 0; j < mas[i].length; j++) {
//                System.out.print(mas[i][j] + "\t");
//            }
//            System.out.println();
//        }

//        int[][] mas = new int[3][];
//        mas[0] = new int[]{1, 2};
//        mas[1] = new int[]{3, 4, 5};
//        mas[2] = new int[]{6, 7, 8, 9};
//        int[][] mas = new int[][]{{1, 2}, {3, 4, 5}, {6, 7, 8, 9}};
//
//        for (int i = 0; i < mas.length; i++) {
//            for (int j = 0; j < mas[i].length; j++) {
//                System.out.print(mas[i][j] + "\t");
//            }
//            System.out.println();
//        }

//        int n = 5;
//        int arr[][] = new int[n][];
//
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = new int[i + 1];
//        }
//
//        int count = 0;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                arr[i][j] = count++;
//            }
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j] + "\t");
//            }
//            System.out.println();
//        }

//        int n = 5;
//        int arr[][] = new int[n][];
//
//        for (int i = 0; i < arr.length; i++) {
////            arr[i] = new int[n - i];
//            arr[i] = new int[arr.length - i];
//        }
//
//        int count = 10;
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                arr[i][j] = count++;
//            }
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j] + "\t");
//            }
//            System.out.println();
//        }


//        int n = 10;
//        int[][] tp = new int[n][];
//        for (int i = 0; i < n; i++) {
//            tp[i] = new int[i + 1];
//            tp[i][0] = 1;
//            tp[i][i] = 1;
//            for (int j = 1; j < i; j++) {
//                tp[i][j] = tp[i - 1][j - 1] + tp[i - 1][j];
//            }
//        }
//
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j <= n - i; j++) {
//                System.out.print("   ");
//            }
//            for (int j = 0; j < tp[i].length; j++) {
//                System.out.print(tp[i][j] + "    ");
//            }
//            System.out.println();
//        }

//        float num = 5.25f;
//
//        System.out.println(Math.round(num));  // 5
//        System.out.println(Math.floor(num));  // 5.0
//        System.out.println(Math.ceil(num));  // 6.0
//        System.out.println(Math.sqrt(4));  // 2.0
//        System.out.println(Math.pow(4, 2));  // 16.0
//        System.out.println(Math.PI);  // 3.141592653589793

    }
}
