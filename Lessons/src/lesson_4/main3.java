package lesson_4;

public class main3 {
    public static void main(String[] args) {
        Outer out = new Outer("внешний");
        System.out.println(out.name);
        System.out.println(Outer.Inner.age);
        Outer.Inner.info();
        System.out.println(out.inner.innerName);
        out.inner.func();
    }
}

class Outer {
    String name;
    Inner inner;

    Outer(String name) {
        this.name = name;
        inner = new Inner("Внутренний");
    }

    class Inner {
        static int age;
        String innerName;

        static {
            age = 18;
        }

        Inner(String innerName) {
            this.innerName = innerName;
        }

        public static void info(){
            System.out.println("Статический метод");
        }

        public void func(){
            System.out.println("Метод во вложенном классе");
        }
    }
}
