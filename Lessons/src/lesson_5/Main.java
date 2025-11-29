package lesson_5;

public class Main {
    public static void main(String[] args) {
        final int N = 3;
        Shape s[] = new Shape[N];
        s[0] = new Circle();
        s[1] = new Triangle1();
        s[2] = new Square();

        for (int i = 0; i < N; i++) {
            System.out.println(s[i].draw());
            System.out.println(s[i].erase() + "\n");
        }
    }
}

class Shape{
    public String draw(){
        return "Рисуем фигуру";
    }

    public String erase(){
        return "Стираем фигуру";
    }
}

class Circle extends Shape{
    @Override
    public String draw() {
        return "Рисуем круг";
    }

    @Override
    public String erase() {
        return "Стираем круг";
    }
}

class Triangle1 extends Shape{
    @Override
    public String draw() {
        return "Рисуем треугольник";
    }

    @Override
    public String erase() {
        return "Стираем треугольник";
    }
}

class Square extends Shape{
    @Override
    public String draw() {
        return "Рисуем квадрат";
    }

    @Override
    public String erase() {
        return "Стираем квадрат";
    }
}
