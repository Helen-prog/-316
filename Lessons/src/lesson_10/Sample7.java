package lesson_10;

public class Sample7 {
    public static void main(String[] args) {
        HumanFactory<Human> humanFactory = Human::new;
        Human human = humanFactory.create("Olga", "Pavlova");
        System.out.println(human);
    }
}

interface HumanFactory<P extends Human> {
    P create(String firstName, String lastName);
}

class Human{
    String firstName;
    String lastName;

    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
