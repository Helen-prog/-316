package lesson_10;

import java.util.ArrayList;
import java.util.Arrays;

public class Sample6 {
    public static void main(String[] args) {
        Person p1 = new Person("Роман", 35, true, PetPreference.DOG, new ArrayList<>(Arrays.asList("изучение языков", "чтение")));
        Person p2 = new Person("Мария", 25, false, PetPreference.CAT, new ArrayList<>(Arrays.asList("туризм", "путешествия")));
        Person p3 = new Person("Алексндр", 15, true, PetPreference.DOG, new ArrayList<>(Arrays.asList("анатомия", "биология")));
        Person p4 = new Person("Михаил", 28, false, PetPreference.SNAKE, new ArrayList<>(Arrays.asList("плаванье", "путешествия")));

        ArrayList<Person> people = new ArrayList<>(Arrays.asList(p1, p2, p3, p4));
        System.out.println(filter(people, p -> p.isExtrovert()));
    }

    public static ArrayList<Person> filter(ArrayList<Person> people, Bias bias) {
        ArrayList<Person> filteredPeople = new ArrayList<>();
        for (Person p : people) {
            if(bias.test(p)){
                filteredPeople.add(p);
            }
        }
        return filteredPeople;
    }
}

interface Bias{
    boolean test(Person p);
}

enum PetPreference{
    DOG, CAT, SNAKE;
}

class Person{
    private String name;
    private int age;
    private boolean extrovert;
    private PetPreference petPreference;
    private ArrayList<String> hobbies;

    public Person(String name, int age, boolean extrovert, PetPreference petPreference, ArrayList<String> hobbies) {
        this.name = name;
        this.age = age;
        this.extrovert = extrovert;
        this.petPreference = petPreference;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public boolean isExtrovert() {
        return extrovert;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", extrovert=" + extrovert +
                ", petPreference=" + petPreference +
                ", hobbies=" + hobbies +
                '}';
    }
}