package lesson_4;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        Person person = new Person("Виктор");
//        person.displayInfo();
//
//        person.setName("Валентина");
//        person.setAge(-30);
//
//        person.displayInfo();

        Random rand = new Random();

        int min = 5;
        int max = 10;
        int cnt = 30;
        for (int i = 0; i < cnt; i++) {
//            System.out.println(rand.nextBoolean());
//            System.out.println(rand.nextDouble());
            System.out.println(rand.nextInt(max - min + 1) + min);  // (10 - 5 + 5)  от 5 до 10
        }
    }
}

class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if(age > 0 && age < 110)
            this.age = age;
    }

    void displayInfo() {
        System.out.println(STR."Name: \{this.name}\nAge: \{this.age}");
    }
}
