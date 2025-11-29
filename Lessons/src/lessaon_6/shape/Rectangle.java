package lessaon_6.shape;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height, String color) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }

    @Override
    public void info() {
        System.out.printf("=== Прямоугольник ===%nШирина: %d%nВысота: %d%nЦвет: %s%nПлощадь: %.1f%nПериметр: %.1f%n", width, height, getColor(), getArea(), getPerimeter());
        draw();
    }

    @Override
    public void draw() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
