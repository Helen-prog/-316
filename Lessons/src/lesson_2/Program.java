package lesson_2;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
//        hello("Irina");
//        hello("Igor");

//        int a = 30;
//        int b = 45;
//        System.out.println("a = " + a + ", b = " + b);
//
//        swapFunction(a, b);
//
//        System.out.println("a = " + a + ", b = " + b);

//        sum( 1, 2, 3);
//        sum(1, 2, 3, 4, 5);
//        sum(5);

//        int a = 7;
//        int b = 8;
//        double c = 5.1;
//        double d = 7.5;
//
//        int res1 = min(a, b);
//        System.out.println(res1);
//
//        double res2 = min(c, d);
//        System.out.println(res2);

        int num = 4;
        String str = "2 x 2 =";
        print(str);
        print(num);
        print(str, num);
        print(num, str);
    }

    public static void print(String str) {
        System.out.println(str);
    }

    public static void print(int num) {
        System.out.println(num);
    }

    public static void print(String str, int num) {
        System.out.println(str + " " + num);
    }

    public static void print(int num, String str) {
        System.out.println(str + " " + num);
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static double min(double a, double b) {
        return a < b ? a : b;
    }

    public static void sum(int message,  int ...num) {
        int res = 0;
        for (int n: num){
            res += n;
        }
        System.out.println(message + ", " + res);
    }

    public static void swapFunction(int a, int b) {
        System.out.println("До замены: a = " + a + ", b = " + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("После замены: a = " + a + ", b = " + b);
    }

    public static void hello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}
