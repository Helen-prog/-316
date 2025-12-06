package lesson_10;

@FunctionalInterface
interface Operation {
    int execute(int a, int b);
//    String concat(String a, String b);
}

public class LambdaApp {
    public static void main(String[] args) {
        Operation func = action(1);
        int result1 = func.execute(2, 3);
        System.out.println(result1);

        int result2 = action(2).execute(8, 2);
        System.out.println(result2);
    }

    private static Operation action(int number) {
        switch (number) {
            case 1:
                return (x, y) -> x + y;
            case 2:
                return (x, y) -> x - y;
            case 3:
                return (x, y) -> x * y;
            default:
                return (x, y) -> 0;
        }
    }
}
