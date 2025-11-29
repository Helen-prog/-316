package lesson_4;

public class Main4 {
    public static void main(String[] args) {
       Dog d = new Dog("Шарик");
       d.run();
       Dog d2 = new Dog("Найда");
       d2.run();
    }
}

class Dog{
    private String name;
//    private Foot foot;

    Dog(String name) {
        this.name = name;
//        foot = new Foot();
    }

    void run(){
        class Foot{
            void run(){
                String name = "Foot";
                System.out.println(STR."Собака \{Dog.this.name} бежит...");
            }
        }
        Foot foot = new Foot();
        System.out.println("Экземпляр класса foot");
        foot.run();
    }


}
