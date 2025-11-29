package lesson_5.shape;

public class Main {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(-10, 20, "green");
//        rect.setHeight(5);
        System.out.println(STR."Ширина: \{rect.getWidth()}");
        System.out.println(STR."Высота: \{rect.getHeight()}");
        System.out.println(STR."Цвет: \{rect.getColor()}");

        System.out.println(STR."Площадь: \{rect.area()}");
    }
}
