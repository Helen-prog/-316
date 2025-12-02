package lesson_7.base;

public class Rectangle extends Shape implements MathShape, ShapeInterface {

    private double width;
    private double height;

    public Rectangle(int width, String color, double width1, double height) {
        super(width, color);
        this.width = width1;
        this.height = height;
    }

    @Override
    void draw() {
        System.out.println("Рисование прямоугольника");
    }

    public double getSquare(){
        return this.width * this.height;
    }

    @Override
    public void info() {
        System.out.println("Ширина: " + width + "\nВысота: " + height + "\n");
    }
}
