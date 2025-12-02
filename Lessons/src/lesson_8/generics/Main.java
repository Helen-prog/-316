package lesson_8.generics;



public class Main {
    public static void main(String[] args) {
        Integer[] intArr = {2, 1, 5, 6, 3, 4};
        Double[] doubleArr = {2.1, 2.2, 2.3, 2.4, 2.5, 2.6};
        Character[] charArr = {'A', 'B', 'C', 'D', 'E', 'F'};

        printArray(intArr);
        printArray(doubleArr);
        printArray(charArr);

    }

    public static <T> void printArray(T[] inputArray){
        for(T element : inputArray){
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
