package lessaon_6.table;

public class Main {
    public static void main(String[] args) {
        SquareTable t = new SquareTable(20, 10);
        t.calcArea();
        SquareTable t2 = new SquareTable(20);
        t2.calcArea();
        RoundTable t3 = new RoundTable(20);
        t3.calcArea();
    }
}
