package lesson_8.generics;

public class Sample2 {
    public static void main(String[] args) {
        Point1<Integer> pt = new Point1<>(1, 2);
        Point1<Double> pt2 = new Point1<>(1.0, 2.0);

//        double max = pt.getMax();
//        System.out.println("max = " + max);

        System.out.println(pt.equalsPoint(pt2));
    }
}

class Point1<T extends Number> {
    public T x, y;

    public Point1(T x, T y) {
        this.x = x;
        this.y = y;
    }

    double getMax(){
        double xd = x.doubleValue();
        double yd = y.doubleValue();
        return (xd < yd) ? yd : xd;
    }

    boolean equalsPoint(Point1<?> pt) {
        return x.doubleValue() == pt.x.doubleValue() && y.doubleValue() == pt.y.doubleValue();
    }
}