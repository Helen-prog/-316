package lesson_8.generics_program;

public class FigureStats <FigureType extends Figure>{
    FigureType[] arr;

    public FigureStats(FigureType[] arr) {
        this.arr = arr;
    }

    public double getSumArea(){
        double res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += arr[i].getArea();
        }
        return res;
    }

    public double getMaxArea(){
        double maxArea = Double.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getArea() > maxArea) {
                maxArea = arr[i].getArea();
            }
        }

        return maxArea;
    }

    public double getMinArea(){
        double minArea = Double.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getArea() < minArea) {
                minArea = arr[i].getArea();
            }
        }
        return minArea;
    }
}
