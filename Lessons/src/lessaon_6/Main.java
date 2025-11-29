package lessaon_6;

public class Main {
    public static void main(String[] args) {
        final int N = 2;
        Animal animal[] = new Animal[N];
        animal[0] = new Dog("Герда");
        animal[1] = new Cat("Том");

        for (Animal a : animal) {
            a.makeSound();
            a.sleep();
        }

    }
}

abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void makeSound();

    public void sleep(){
        System.out.println(name + " спит!");
    }
}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " гавкает!");
    }
}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " мяукает!");
    }
}
