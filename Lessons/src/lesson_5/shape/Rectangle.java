package lesson_5.shape;


public class Rectangle extends Figure {
    private double width;
    private double height;

    public Rectangle(double width, double height, String color) {
        super(color);
//        this.width = width;
//        this.height = height;
        setWidth(width);
        setHeight(height);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width < 0)
            throw new IllegalArgumentException("Требуется положительное число");
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height > 0)
            this.height = height;
    }

    int area(){
        return (int)(width * height);
    }
}
