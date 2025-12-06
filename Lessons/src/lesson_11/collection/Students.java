package lesson_11.collection;

public class Students {
    public static void main(String[] args) {
        Person e1 = new Person("Александр", 25);
        Person e2 = new Person("Светлана", 25);
        int res = e1.compareTo(e2);
        switch (res) {
            case -1:
                System.out.println(e2.getName() + " старше!");
                break;
            case 1:
                System.out.println(e1.getName() + " старше!");
                break;
            default:
                System.out.println("Это люди одного возраста!");
        }
    }
}

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person o) {
        if (this.age == o.age) {
            return 0;
        } else {
            return this.age > o.age ? 1 : -1;
        }
    }
}
