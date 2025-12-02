package lesson_7.enums;


enum Seasons {
    WINTER("Зима"),   // public static final
    SPRING("Весна"),
    SUMMER("Лето"),
    AUTUMN("Осень");

    private String title;

    Seasons(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Seasons{title='" + title + "'}";
    }
}


public class Main {
    public static void main(String[] args) {
//        System.out.println(Seasons.WINTER);
//        System.out.println(Seasons.SPRING);
//        System.out.println(Seasons.SUMMER);
//        System.out.println(Seasons.AUTUMN);
//        for (Seasons season : Seasons.values()) {
//            System.out.println(season);
//        }
//        Seasons season = Seasons.SPRING;
//
//        switch (season) {
//            case WINTER:
//                System.out.println("Winter");
//                break;
//            case SPRING:
//                System.out.println("Spring");
//                break;
//        }
        for (Seasons season : Seasons.values()) {
            System.out.println(season.name());
        }
        int index = Seasons.SUMMER.ordinal();
        System.out.println(index);
    }
}
