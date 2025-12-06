package lesson_9;

public class Main4 {
    public static void main(String[] args) {
        try {
            ex();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("done");
    }

    public static void ex() throws RuntimeException{
        throw new RuntimeException("Hello Exception");
    }
}
