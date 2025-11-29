package lessaon_6.shape;


public class Main {
    public static void main(String[] args) {
//        Square square = new Square(3, "red");
//        square.info();
//        Rectangle rect = new Rectangle(7, 3, "green");
//        rect.info();

        final int N = 3;
        Shape[] squares = new Shape[N];
        squares[0] = new Square(3, "red");
        squares[1] = new Rectangle(7, 3, "green");
        squares[2] = new Triangle(5, "yellow");

        for(Shape s : squares) {
            s.info();
        }
    }
}
