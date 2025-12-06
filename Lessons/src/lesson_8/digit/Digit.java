package lesson_8.digit;

public class Digit {
    public double value;

    public <T extends Number> Digit(T value) {
        this.value = value.doubleValue();
    }
}
