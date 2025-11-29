package lessaon_6.table;

public class SquareTable extends Table {

    public SquareTable(int width, int height) {
        super(width, height);
    }

    public SquareTable(int width) {
        super(width);
    }

    @Override
    public void calcArea() {
        System.out.printf("Ширина: %d%nВысота: %d%nПлощадь: %d%n%n", getWidth(), getHeight(), getWidth() * getHeight());
    }
}
