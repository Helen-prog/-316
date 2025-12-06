package lesson_9;

import java.io.IOException;

public class Main3 {
    public static void main(String[] args) throws NegativeWidthException {

        Square square = new Square(10);
        square.setWidth(-2);

        System.out.println("Ширина квадрата: " + square.getWidth());
        System.out.println("Площадь: " + square.calculateArea(square.getWidth()));
    }
}

class NegativeWidthException extends Exception {
    public NegativeWidthException(String message) {
        super(message);
    }
}

class Square{
    private int width;

    public Square(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int calculateArea(int width) throws NegativeWidthException {
        if (width >= 0) {
            return width * width;
        } else{
            throw new NegativeWidthException("Ширина квадрата " + width + ". Значение не может быть отрицательным");
        }
    }
}
