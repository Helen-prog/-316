package lesson_3;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        String str1 = "Hello";
//        String str2 = "World";
//        String str3 = str1 + " " + str2;
//        System.out.println(str3);
//        System.out.println(STR."Конкатенация: \{str1} \{str2}");
//        char[] helloArray = {'П', 'р', 'и', 'в', 'е', 'т', '.'};
//        String helloString = new String(helloArray);  // Привет.
//        int a = 5;
//        helloString = helloString + a;
//        System.out.println(helloString);
//        String message = a + "";
//        String message1 = STR."\{a}";
//        System.out.println(message);
//        System.out.println(message1);

//        String str1 = "2";
////        int a = Integer.parseInt(str1);
//        int a = Integer.parseInt("789");
//        System.out.println(a);

//        String name = "Hello";
////        int count = (name + 57).length();  // "Hello57"
//        int count = "".length();  //
//        System.out.println(count);

//        String name = "Nikita";
//        String name1 = name.toUpperCase();
//        System.out.println(name1);
//
//        String name2 = name1.toLowerCase();
//        System.out.println(name2);
//
//        System.out.println(name.charAt(0));

//        String s1 = "";
//        if(s1.isEmpty()){   // s1.length() == 0
//            System.out.println("Пустая строка");
//        }

//        String str = "ABC";
//        char[] chars = str.toCharArray();
//        System.out.println("Массив символов:");
//        for (int i = 0; i < chars.length; i++) {
//            System.out.println("Элемент [" + i + "]: " + chars[i]);
//        }

//        String path = "https://www.oracle.com/java/technologies/downloads/#jdk20-windows";
//        char[] chars = path.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            if(chars[i] == '/') {
//                chars[i] = '\\';
//            }
//        }
//        String res = new String(chars);
//        System.out.println(res);


//        String str = "I learning Java";
//        System.out.println(str);
//        System.out.println(str.indexOf("a"));
//        System.out.println(str.lastIndexOf("a"));
//
//        System.out.println(str.indexOf("a", 5));
//        System.out.println(str.lastIndexOf("a", 5));
//
//        System.out.println(str.indexOf("w"));

//        System.out.println(">" + "   Hello World   ".trim() + "<");

//        System.out.println("I learning Java".substring(2));
//        System.out.println("I learning Java".substring(2, 9));

//        String str = "один два";
//        String first = str.substring(0, str.indexOf(" "));
//        String second = str.substring(str.indexOf(" ") + 1);
//        System.out.println(STR."\{second} \{first}");

//        String str = "I learning Java";
//        String[] words = str.split(" ");
//        for (String word : words) {
//            System.out.println(word);
//        }


//        String str = "Никонов Валерий Анатольевич";
//        String[] fio = str.split(" ");  // ["Никонов", "Валерий", "Анатольевич"]
//        System.out.println(STR."\{fio[0]} \{fio[1].charAt(0)}. \{fio[2].charAt(0)}. ");

//        System.out.println(reverseString("Строка"));

//        String res = String.join(":", "00", "23", "30");
//        System.out.println(res);
//
//        String[] text = new String[] {"Hello", "World", "!"};
//        String str = String.join("_", text);
//        System.out.println(str);

//        String text = "Я изучаю Java. Мне нравится Java.";
//        System.out.println(text);
//        String[] words = text.split("Java");  // ["Я изучаю ", ". Мне нравится ", "."]
//        String res = String.join("C++", words);
//        System.out.println(res);

//        String text = "Я изучаю Java. Мне нравится Java.";
//        text = text.replace("Java", "C++");
//        System.out.println(text);

//        String s1 = "Hello";
//        String s2 = "Hello";
//        String s3 = "Good-bye";
//        String s4 = "HELLO";
//        System.out.println(STR."\{s1} == \{s2} => \{s1.equals(s2)}");
//        System.out.println(STR."\{s1} == \{s3} => \{s1.equals(s3)}");
//        System.out.println(STR."\{s1} == \{s4} => \{s1.equals(s4)}");
//        System.out.println(STR."\{s1} == (IgnoreCase) \{s4} => \{s1.equalsIgnoreCase(s4)}");

//        String str = "I learning Java";
//        System.out.println(str.endsWith("Java"));
//        System.out.println(str.startsWith("I"));
//        System.out.println(str.contains("ing"));
//        System.out.println(str.codePointAt(0));
//        System.out.println(str.codePointAt(3));
//        System.out.println(str.codePointBefore(3));

//        String s;

//        double d = 3.7894;
//        int d = -3456;
//        char d = '+';
//        boolean d = true;
//        s = String.valueOf(d);
//        System.out.println(s);
    }

    public static String reverseString(String str) {
        String result = "";  // "ртC"
        for (int i = 0; i < str.length(); i++) {
            result = str.charAt(i) + result;
        }
        return result;
    }
}
