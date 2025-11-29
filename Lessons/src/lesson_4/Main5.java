package lesson_4;

public class Main5 {
    public static void main(String[] args) {
        Main5 m = new Main5();
        m.print();
    }

    private int outer_x = 100;

    void print(){
        Inner inner = new Inner();
        inner.innerMethod();
    }

    class Inner{
        public void innerMethod(){
            System.out.println(outer_x);
        }
    }
}
