package lessaon_6.shape;

public abstract class Shape {
    private String color;

    public Shape() {
    }

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract void info();
    public abstract void draw();
}
