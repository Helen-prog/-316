package lesson_7.base;

public class Triangle extends Shape implements MathShape, ShapeInterface{
    private int length;
    private int height;

    public Triangle(int width, String color, int length, int height) {
        super(width, color);
        this.length = length;
        this.height = height;
    }

    @Override
    void draw() {
        System.out.println("Рисование треугольника");
    }

    public double getSquare(){
        return 0.5 * length * height;
    }

    @Override
    public void info() {
        System.out.println("Длина: " + length + "\nВысота: " + height + "\n");
    }
}
