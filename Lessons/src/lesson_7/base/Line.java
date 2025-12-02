package lesson_7.base;

public class Line extends Shape implements ShapeInterface, MathGeom, GeomInterface {

    private int x1, x2, y1, y2;

    public Line(int width, String color, int x1, int x2, int y1, int y2) {
        super(width, color);
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public double getSquare(){
        return GeomInterface.super.getSquare();
    }

    @Override
    void draw() {
        System.out.println("Рисование линии");
    }

    @Override
    public void info() {
        System.out.println("Координаты линии: " + x1 + "," + y1 + "," + x2 + "," + y2);
        GeomInterface.showInterval();
        System.out.println();
    }

    private boolean isCheck(int x){
        return (MIN_COORDS <= x && x <= MAX_COORDS);
    }

    void setCoords(int x1, int y1, int x2, int y2) {
        if(isCheck(x1) && isCheck(x2) && isCheck(y1) && isCheck(y2)) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
    }
}
