package lessaon_6.shape;

public class Triangle extends Shape {
    private int side;

    public Triangle(int side, String color) {
        super(color);
        this.side = side;
    }

    @Override
    public double getArea() {
        return Math.sqrt(3) / 4 * Math.pow(side, 2);
    }

    @Override
    public double getPerimeter() {
        return side * 3;
    }

    @Override
    public void info() {
        System.out.printf("=== Равносторонний треугольник ===%nСторона: %d%nЦвет: %s%nПлощадь: %.1f%nПериметр: %.1f%n", side, getColor(), getArea(), getPerimeter());
        draw();
    }

    @Override
    public void draw() {
        for (int i = 0; i < side; i++) {
            for (int j = i; j < side; j++) {

                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(" *  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
