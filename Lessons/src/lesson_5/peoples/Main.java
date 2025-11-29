package lesson_5.peoples;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Батолаев", "Даши", 16, "ГК", "Web_011", 5);
//        student1.info();
        Student student2 = new Student("Загидуллин", "Линар", 32, "ПКО", "ЗВ_011", 5);
//        student2.info();
        Teacher teacher1 = new Teacher("Даньшин", "Андрей", 38, "Астрофизика", 110);
//        teacher1.info();
        Graduate graduate1 = new Graduate("Шугани", "Сергей", 15, "РПО", "PD_011", 5, "Защита персональных данных");
//        graduate1.info();

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(teacher1);
        System.out.println(graduate1);

        Human human = new Human("Montana", "Antonio", 30);
        System.out.println(human);
        Student student3 = new Student(human, "physics", "PH_120", 5);
        System.out.println(student3);

        Graduate graduate2 = new Graduate(student1, "Mathematical calculations");
        System.out.println(graduate2);
    }
}
