package lesson_7.base;

public class Base {
    public static void main(String[] args) {
//        final int N = 3;
//        Shape[] shapes = new Shape[N];
//        shapes[0] = new Line(5, "red", 1, 2, 3, 4);
//        shapes[1] = new Rectangle(2, "yellow", 5, 10);
//        shapes[2] = new Triangle(3, "green", 4, 10);
//
//        ShapeInterface sh[] = new ShapeInterface[N];
//        sh[0] = new Line(5, "red", 1, 2, 3, 4);
//        sh[1] = new Rectangle(2, "yellow", 5, 10);
//        sh[2] = new Triangle(3, "green", 4, 10);
//
//        //        for(Shape shape : shapes) {
////            shape.draw();
////        }
//        for (int i = 0; i < shapes.length; i++) {
//            shapes[i].draw();
//            if(shapes[i] instanceof MathShape) {
//                double s = ((MathShape) shapes[i]).getSquare();
//                System.out.println("Площадь: " + s);
//            }
//            sh[i].info();
        // }

        Line l = new Line(2, "red", 10, 20, 30, 40);
        l.info();
        l.setCoords(50,60,70,1080);
        l.info();
        GeomInterface.showInterval();
        System.out.println(l.getSquare());

    }
}

interface MathGeom{
    default double getSquare(){
        return 0;
    }
}

interface GeomInterface {
    int MIN_COORDS = 0;  // public static final
    int MAX_COORDS = 1000;

    static void showInterval(){
        System.out.println("[" + MIN_COORDS + ", " + MAX_COORDS + "]");
    }

    default double getSquare(){
        return -1;
    }
}

interface ShapeInterface {
    void info();
}

class InterfaceGroup{
    private interface Interface_1{
        void method_1();
    }

    interface Interface_2 extends Interface_1{
        void method_2();
    }
}

class ReleaseInterface implements InterfaceGroup.Interface_2 {
    @Override
    public void method_2() {

    }

    @Override
    public void method_1() {

    }
}

//interface MathShape{
//    double getSquare();
//}
