package lesson_8.mathematics;

public class Math {
    public static <T> boolean isIn(T val, T[] arr) {
        for(T v: arr){
            if(v.equals(val)){
                return true;
            }
        }
        return false;
    }
}
