package lesson_8.mathematics;

public class Main {
    public static void main(String[] args) {
        Short ar[] = {1, 2, 3, 4};
        Short val = 4;
        boolean flIn = Math.<Short>isIn(val, ar);
        System.out.println(flIn);
    }
}
