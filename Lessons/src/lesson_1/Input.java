package lesson_1;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.print("Возраст: ");
//        int age = sc.nextInt();
//        System.out.print("Рост: ");
//        float height = sc.nextFloat();
//        sc.nextLine();
//        System.out.print("Имя: ");
//        String name = sc.nextLine();
//
//        System.out.printf("Имя: %s. Возраст: %d. Рост: %.2f", name, age, height);

//        System.out.print("Возраст: ");
//        int age = sc.nextInt();
//        System.out.print("Рост: ");
//        float height = sc.nextFloat();
//        System.out.print("Имя: ");
//        String name = sc.next();
//
//        System.out.printf("Имя: %s. Возраст: %d. Рост: %.2f", name, age, height);

//        System.out.print("Имя: ");
////        String name = sc.next();  // Мария
//        String name = sc.nextLine();  // Мария Петрова
//        System.out.println(name);

//        int num = 5;
//        num += 10;  // num = num + 10
//        num -= 3;
//        System.out.println(num);

//        boolean a = 5 > 6 && 4 < 6;
//
//        System.out.println(a);

        int num1 = 17;
        int num2 = 7;
//        if(num1 > num2){
//            System.out.println(num1 + " > " + num2);
//        }
//        else if(num1 < num2){
//            System.out.println(num2 + " > " + num1);
//        }
//        else{
//            System.out.println(num1 + " == " + num2);
//        }
//        if(num1 > num2){
//            System.out.println(num1 + " > " + num2);
//        }
//        if(num1 < num2){
//            System.out.println(num2 + " > " + num1);
//        }
//        if(num1 == num2){
//            System.out.println(num1 + " == " + num2);
//        }
//        System.out.print("Ваш возраст: ");
//        int age = sc.nextInt();
//        boolean isYoung = age < 18;
//        if (!isYoung && age <= 65) {
//            System.out.println("Вы можете работать");
//        }else {
//            System.out.println("Работать не обязательно");
//        }

//        int n;
//        System.out.print("Введите количество ворон: ");
//        n = sc.nextInt();
//        if (n >= 0 && n <= 9){
//            System.out.print("На ветке " + n + " ворон");
//            if(n == 1){
//                System.out.println("а");
//            } else if(n >= 2 && n <= 4){
//                System.out.println("ы");
//            } else {
//                System.out.println("");
//            }
//        } else {
//            System.out.println("Ошибка ввода данных");
//        }

//        int n = true ? (false ? 10 : 20) : 30;
//        System.out.println(n);  // 20

//        int n;
//        System.out.print("Выбор цвета светофора\n1 (11) - красный, 2 (22) - желтый, 3 (33) - зеленый: ");
//        n = sc.nextInt();
//        switch (n) {
//            case 1, 11 -> System.out.println("Стоим");
//            case 2, 22 -> System.out.println("Приготовиться");
//            case 3, 33 -> System.out.println("Идем");
//            default -> System.out.println("Такого цвета светофора нет");
//        }

//        int n;
//        System.out.print("Выбор цвета светофора\n1 (11) - красный, 2 (22) - желтый, 3 (33) - зеленый: ");
//        n = sc.nextInt();
//        String s = switch (n) {
//            case 1, 11 -> "Стоим";
//            case 2, 22 -> "Приготовиться";
//            case 3, 33 -> "Идем";
//            default -> "Такого цвета светофора нет";
//        };
//        System.out.println(s);

//        System.out.print("Введите балл по 12 бальной системе оценивания: ");
//        int num = sc.nextInt();
//        System.out.print("Ваш бал по 5 системе оценивания: ");
//        switch (num >= 1 && num <= 3 ? 2 :
//                num >= 4 && num <= 6 ? 3 :
//                num >= 7 && num <= 9 ? 4 :
//                num >= 10 && num <= 12 ? 5 : 0
//        ) {
//            case 2 -> System.out.println(2);
//            case 3 -> System.out.println(3);
//            case 4 -> System.out.println(4);
//            case 5 -> System.out.println(5);
//            case 0 -> System.out.println("такого значения нет");
//        }


        sc.close();
    }
}
