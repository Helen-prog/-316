package lesson_10;

interface WordCounter{
    int countWords(String text);
}

public class Sample1 {
    public static void main(String[] args) {
        String text = "Лямбда выражение";
        System.out.println("Исходная строка: " + text);
        WordCounter counter = s -> s.split("\\s+").length;
        int words = counter.countWords(text);
        System.out.println("Количество слов: " + words);
        text = "Программа, которая подсчитывает количество слов в предложении";
        System.out.println("Исходная строка: " + text);
        words = counter.countWords(text);
        System.out.println("Количество слов: " + words);
    }
}
