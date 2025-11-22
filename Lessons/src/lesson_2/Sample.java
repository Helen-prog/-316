package lesson_2;

import java.util.Scanner;

public class Sample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.print("На каком вы этаже: ");
//        int a = sc.nextInt();
//        elevator(a);
//        int[] mas = {1, 3, 5, 7, 9};
//        System.out.println(sumList(0, mas));  // 25

        System.out.println(toStr(254, 16));
    }

    public static String toStr(int n, int base) {  // 15
        String[] convert = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        if(n < base){  // 15 < 16
            return convert[n];  // "F"
        } else {
            return toStr(n / base, base) + convert[n % base];   // "E"
        }
    }





    public static int sumList(int i, int[] mas) {  // sumList(4, {1, 3, 5, 7, 9})
        if(i == (mas.length - 1)) {  // 4 == 4
            return mas[i];  // 9
        }
        return mas[i] + sumList(i + 1, mas);  // 1 + 3 + 5 + 7 + 9
    }
//    public static int sum_list(int[] mas) {
//        int sum = 0;
//        for(int i:mas)
//            sum += i;
//        return sum;
//    }

    public static void elevator(int n) {
        if (n == 0) {
            System.out.println("Вы в подвале");
            return;
        }
        System.out.println("=> " + n);
        elevator(n - 1);
        System.out.print(n + " ");
    }
}
