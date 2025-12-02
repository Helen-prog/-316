package lesson_7.base;

public abstract class Shape {
    private int width;
    private String color;

    public Shape(int width, String color) {
        this.width = width;
        this.color = color;
    }

    abstract void draw();
}
