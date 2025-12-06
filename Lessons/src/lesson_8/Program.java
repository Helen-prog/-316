package lesson_8;

public class Program {
    public static void main(String[] args) {
        GeomInterface<Float> pt = new Point<>();
        pt.setCoords(10f, 20f);

        System.out.println(pt.getCoords(TypeCoords.COORDS_X));
        System.out.println(pt.getCoords(TypeCoords.COORDS_Y));
    }
}

enum TypeCoords {
    COORDS_X, COORDS_Y;
}

interface GeomInterface<T> {
    void setCoords(T x, T y);

    T getCoords(TypeCoords type);
}

class Point<TT> implements GeomInterface<TT> {

    private TT x, y;

    @Override
    public void setCoords(TT x, TT y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public TT getCoords(TypeCoords type) {
        return (type == TypeCoords.COORDS_X) ? x : y;
    }
}
