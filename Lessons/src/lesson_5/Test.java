package lesson_5;

public class Test {
    public static void main(String[] args) {
        Line l1 = new Line();
//        l1.color = "red";
//        l1.width = 5;
//        l1.x1 = l1.y1 = 0;
//        l1.x2 = l1.y2 = 10;
//        l1.showProp();
//        l1.show();
//        Properties p = l1;
//        p.color = "blue";
//        p.width = 1;
////        p.x1 = -1;
//        p.showProp();
//        l1.show();
//        l1.show();
//        l1.showId();
//        Object g1 = new Line();
//        Object g2 = new Triangle();
//        Object g3 = new Properties();
//
//        System.out.println(g1 instanceof Line);
//        System.out.println(g3 instanceof Line);
//
//        Line l1 = null, l2 = null;
//        if(g1 instanceof Line) {
//            l1 = (Line) g1;
//        }
//        if(g2 instanceof Line) {
//            l2 = (Line) g2;
//        }
        System.out.println(l1.id);
        l1.show();
    }
}

class Properties {
    int width;
    String color;
    final int id = 1;

    public Properties() {
        System.out.println("Конструктор Properties");
    }

    public Properties(int width, String color) {
        this.width = width;
        this.color = color;
        System.out.println("Конструктор Properties(width, color)");
    }

    void show(){
        System.out.println(STR."Ширина - \{width}px, Цвет - \{color}");
    }
}

class Line extends Properties {
    double x1, y1, x2, y2;
    int id = 2;

    public Line() {
        super(0, "");
        System.out.println("Конструктор Line");
    }

    void show(){
        super.show();
        System.out.println(STR."Координаты линии - x1: \{x1}, y1: \{y1}, x2: \{x2}, y2: \{y2}");
    }

    void showId(){
        System.out.println(STR."id = \{id}, super.id = \{
                super.id
                }");
    }
}

class Triangle extends Properties {
    double x1, y1, x2, y2, x3, y3;
}
